package com.cltech.hrms.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cltech.hrms.bean.ResponseBean;
import com.cltech.hrms.bean.user.User;
import com.cltech.hrms.service.user.UserService;


@RestController
//@CrossOrigin( origins= {"*"},allowCredentials = "false",maxAge = 4800)
@RequestMapping("/authentication")
public class AuthenticationController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/registration")
	@ResponseBody
    public ResponseBean registration(@RequestBody User user) {
        return userService.registration(user);
    }

	@PostMapping("/login")
    @ResponseBody
    public ResponseBean login(@RequestBody User user) {
        return userService.loginAuthentication(user);
    }
	
	@GetMapping("/getAllUser")
	public ResponseBean getAllUser() {
		return userService.getAllUserService();
		
	}
	

}
