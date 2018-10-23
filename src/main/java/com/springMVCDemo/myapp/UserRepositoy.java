package com.springMVCDemo.myapp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springMVCDemo.myapp.io.entity.UserEntity;


/**
 *This provides readymade methods to perform crud operations like create, update delete in database
 *This eliminates need to create separate DAO for each operation 
 *Any custom method can be defined here (Like search by email) 
 */
@Repository
public interface UserRepositoy extends CrudRepository<UserEntity, Long> {
	//This method name is important; to query a table use the syntax: findBy<columnToQuery>
	//Here we look up by email so the name; How it is done is BLACKBOX!
	UserEntity findByEmail(String email); 
}
