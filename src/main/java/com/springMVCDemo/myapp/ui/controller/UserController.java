package com.springMVCDemo.myapp.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springMVCDemo.myapp.service.UserService;
import com.springMVCDemo.myapp.shared.dto.UserDto;
import com.springMVCDemo.myapp.ui.model.request.UserDetailsRequestModel;
import com.springMVCDemo.myapp.ui.model.response.UserRest;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {

	@Autowired
	UserService userService;
	@GetMapping
	public String getUser()
	{
		return "getUser was called";
	}
	
	@PostMapping 
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) 
	{
		UserRest returnValue = new UserRest();
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto); //Copies the request values to dto ie JSON data to java object conversion
		/*So now the userdto contains all the information to be written/updated in the database
		 * This userdto oobject can now be shared amond layers to perform operations/modifications on it before writing to database
		 */
		
		//Create a service to implement the business logic on this userdto
		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser,returnValue); //Copy the modified userDto object after writing in database in returnValue to be sent back as response
		
		return returnValue; 
	}
	
	@PutMapping
	public String updateUser()
	{
		return "updateUser was called";
	}
	@DeleteMapping
	public String deleteUser()
	{
		return "deleteUser was called";
	}
}
