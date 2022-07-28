package com.cltech.hrms.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cltech.hrms.bean.ResponseBean;
import com.cltech.hrms.bean.common.DataTableRequestBean;
import com.cltech.hrms.bean.user.User;
import com.cltech.hrms.service.user.RoleService;
import com.cltech.hrms.service.user.UserService;


@RestController
@CrossOrigin( origins= {"*"},allowCredentials = "false",maxAge = 4800)
@RequestMapping("/authentication")
public class AuthenticationController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	@Qualifier("roleServiceImp")
	private RoleService roleService;
	
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
	
	@PostMapping("/getAllUser")
	public ResponseBean getAllUser(@RequestBody DataTableRequestBean dataTableRequestBean) {
		return userService.getAllUser  (dataTableRequestBean);
		
	}
	
	@PostMapping("/updateUserDepartment")
	@ResponseBody
    public ResponseBean updateUserDepartment(@RequestBody User user) {
        return userService.updateUserDepartment(user);
    }
	
	@GetMapping(path="/findUseById/{ID}")
	@ResponseBody
    public ResponseBean findUserById(@PathVariable("ID") Long id) {
        return userService.findById(id);
    }

	@PostMapping("/getRole")
	public ResponseBean getRole() {
		return roleService.getRole  ();
		
	}
}
