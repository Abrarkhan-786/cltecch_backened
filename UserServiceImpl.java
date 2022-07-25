package com.cltech.hrms.service.user.impl;

import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cltech.hrms.bean.ResponseBean;
import com.cltech.hrms.bean.user.User;
import com.cltech.hrms.constant.Status;
import com.cltech.hrms.repository.user.RoleRepository;
import com.cltech.hrms.repository.user.UserRepository;
import com.cltech.hrms.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static Logger LOGGER=LogManager.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public ResponseBean registration(User user) {
    	try {
    		
    		boolean existsByEmail = userRepository.existsByEmail(user.getEmail());
    		if(existsByEmail) {
        		return ResponseBean.builder().status(Status.FAIL).message("User Already Exist").build();
    		}
    		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            //user.setRoles(new HashSet<>(roleRepository.findAll()));
            User userBean = userRepository.save(user);
    		return ResponseBean.builder().status(Status.SUCCESS).message("Register Succesfully").response(userBean).build();
    		
    	}catch(Exception e) {
    		LOGGER.error(e.getMessage(),e);
    		return ResponseBean.builder().status(Status.FAIL).message("Something went wrong").response(user).build();
    	}
        
    }

    @Override
    public ResponseBean findByUsername(String username) {
        try {
        	User userLogin = userRepository.findUserByEmail(username);
            if(userLogin==null) {
        		return ResponseBean.builder().status(Status.FAIL).message("Invalid Credential").build();
            }
            
    		return ResponseBean.builder().status(Status.SUCCESS).message("Login Successfull ").response(userLogin).build();
        	
        }catch(Exception e) {
        	LOGGER.error(e.getMessage(),e);
    		return ResponseBean.builder().status(Status.FAIL).message("somthing went wrong").build();

        }
    }

	@Override
	public ResponseBean loginAuthentication(User userForm) {
		try {
			 User userLogin = userRepository.findUserByEmail(userForm.getEmail());
		      if(userLogin!=null) {
		    	  
		    	if(!bCryptPasswordEncoder.matches(userForm.getPassword(), userLogin.getPassword())) {
		    		return ResponseBean.builder().status(Status.FAIL).message("Invalid Credential").build();
		    	}
				return ResponseBean.builder().status(Status.SUCCESS).message("Login Successfull ").response(userLogin).build();
		      }
				return ResponseBean.builder().status(Status.FAIL).message("Invalid Credential").build();
			
		}catch(Exception e) {
			LOGGER.error(e.getMessage(),e);
			return ResponseBean.builder().status(Status.FAIL).message("something went wrong").build();
		}
		
	}

	public ResponseBean getAllUserService() {
		try {
			 List<User> userList = userRepository.findAll();
		      if(userList!=null) {
		    	  
				return ResponseBean.builder().status(Status.SUCCESS).message("Get All UserList ").response(userList).build();
		      }
				return ResponseBean.builder().status(Status.FAIL).message("No User Available").build();
			
		}catch(Exception e) {
			LOGGER.error(e.getMessage(),e);
			return ResponseBean.builder().status(Status.FAIL).message("something went wrong").build();
		}
	}
	
	
	
	
	
}