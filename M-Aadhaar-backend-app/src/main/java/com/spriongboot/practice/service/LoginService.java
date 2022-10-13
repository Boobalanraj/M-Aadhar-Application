package com.spriongboot.practice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.practice.Entity.LoginEntity;
import com.spriongboot.practice.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	public LoginRepository loginRepository;
	public String signIn(LoginEntity login) {
		Optional<LoginEntity> result = loginRepository.findById(login.getEmailid());
		if(result.isPresent()) {
					LoginEntity ll = result.get();
					if(ll.getPassword().equals(login.getPassword())) {		
						
				if(login.getTypeOfUser().equals(ll.getTypeOfUser()) && login.getTypeOfUser().equals("admin")) {
							return "Admin sucessfully login";
				}else if(login.getTypeOfUser().equals(ll.getTypeOfUser()) && login.getTypeOfUser().equals("user")){
							return "User successfully login";
						}else {
							return "Invalid details";
						}					
					}else {
						return "InValid password";
					}
		}else {
			return "InValid emailId";
		}		
	}
	public String signUp(LoginEntity login) {
		Optional<LoginEntity> result = loginRepository.findById(login.getEmailid());
		if(result.isPresent()) {
					return "Email Id alreay exists";
		}else {
			if(login.getTypeOfUser().equals("admin")) {
				return "You can't create admin account";
			}else {
				loginRepository.save(login);
				return "Account created successfully";
			}
			
		}	
	}
}