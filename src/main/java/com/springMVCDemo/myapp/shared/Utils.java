package com.springMVCDemo.myapp.shared;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {
	
	private final Random RANDOM = new SecureRandom();
	private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	public String generateUserId(int length)
	{
		return generateRandomString(length);
	}
	
	//Generates string of random characters of given length
	private String generateRandomString(int length)
	{
		StringBuilder returnValue =  new StringBuilder(length);
		
		for(int i=0; i < length; i++)
		{
			//Randomly pick a char from ALPHABET length number of times
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		
		return new String(returnValue);
	}

}
