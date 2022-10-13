package com.spriongboot.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.practice.Entity.UserEntity;
import com.spriongboot.practice.repository.UserRepo;


@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	public UserEntity addUser(UserEntity u) {
		return repo.save(u);
	}
	public List<UserEntity> getAllUser(){
		return repo.findAll();
	}
	public UserEntity getUserById(int id) {
		if(repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		}
		else {
			return null;
		}
		
	}
	public UserEntity updateUser(int id, UserEntity newUser) {
		if(repo.findById(id).isPresent()) {
			UserEntity olduser= repo.findById(id).get();
			olduser.setName(newUser.getName());
			olduser.setDob(newUser.getDob());
			olduser.setAddress(newUser.getAddress());
			olduser.setEmail(newUser.getEmail());
			olduser.setMobile(newUser.getMobile());
			olduser.setGender(newUser.getGender());
			
			return repo.save(olduser);
		}
		else {
			return null;
		}
	}
	
	
	public boolean deleteUser(int id) {
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return true;
		}
		
		else {
			return false;
		}
	}
	
	

}
