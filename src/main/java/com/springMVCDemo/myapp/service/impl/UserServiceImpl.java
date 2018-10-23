package com.springMVCDemo.myapp.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springMVCDemo.myapp.UserRepositoy;
import com.springMVCDemo.myapp.io.entity.UserEntity;
import com.springMVCDemo.myapp.service.UserService;
import com.springMVCDemo.myapp.shared.Utils;
import com.springMVCDemo.myapp.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepositoy userRepository;
	
	@Autowired
	Utils utils;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDto createUser(UserDto user) {

		//Query the existing records to check if the new email to be entered is already present
		//Throw an exception if record(EMAIL in this case) is already present in database!
		if(userRepository.findByEmail(user.getEmail())!=null)throw new RuntimeException("Record already exists!");
		
		//Copy information from userDto to user entity to be written in database
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		/*Since some fields are mandatory in entity class they cant be null
		So set some default values to fields that wont be populated from UI layer
		Hard coding now; but values not from UI layer will be generated here*/
		
		//This generates a userId which identifies an entry in DB & can be sent to UI. Sending actual auto increment ID can risk attacks from malicious users 
		String publicUserId =  utils.generateUserId(30);
		
		//These 2 fields wont be set from UI layer but will be generated here by business logic;
		//Since no business logic now, lets hard code them!
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userEntity.setUserId(publicUserId);
		
		
		UserEntity storedUserDetails = userRepository.save(userEntity);
		
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
		
		return returnValue;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
