package com.cltech.hrms.service.user;

import org.springframework.stereotype.Service;

import com.cltech.hrms.bean.ResponseBean;
import com.cltech.hrms.bean.user.User;

@Service
public interface UserService {
	public ResponseBean  registration(User user);
	public ResponseBean  findByUsername(String username);
	public ResponseBean  loginAuthentication(User userForm);
	public ResponseBean getAllUserService();
}
