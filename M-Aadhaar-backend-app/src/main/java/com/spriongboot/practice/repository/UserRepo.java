package com.spriongboot.practice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.practice.Entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer> {

}

