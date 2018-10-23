package com.springMVCDemo.myapp.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.springMVCDemo.myapp.shared.dto.UserDto;

public interface UserService extends UserDetailsService{

	UserDto createUser(UserDto user);
}
