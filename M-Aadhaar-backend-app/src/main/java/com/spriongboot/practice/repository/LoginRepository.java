package com.spriongboot.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.practice.Entity.LoginEntity;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, String>{

}
