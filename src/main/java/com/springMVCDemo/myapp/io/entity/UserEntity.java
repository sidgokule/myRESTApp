package com.springMVCDemo.myapp.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "users")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1349678323178806360L;

	@Id
	@GeneratedValue
	private long id; // Primary key, auto incremented

	@Column(nullable = false) // @Clumn(nullable=false) makes it a mandatory field
	private String userId; // Alphanumeric; sent back to app as response; safe to pass in N/W

	@Column(nullable = false, length = 50) // Default length of 256 will make inefficient hence specify length
	private String firstName;

	@Column(nullable = false, length = 50)
	private String lastName;

	@Column(nullable = false, length = 120) 
	//@Column(nullable = false, length = 120, unique = true) Unique = true will allow only one entry to be made in database
	private String email;

	@Column(nullable = false)
	private String encryptedPassword;

	private String emailVerification;

	@Column(nullable = false)
	private Boolean emailVerificationStatus = false;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getEmailVerification() {
		return emailVerification;
	}

	public void setEmailVerification(String emailVerification) {
		this.emailVerification = emailVerification;
	}

	public Boolean getEmailVerificationStatus() {
		return emailVerificationStatus;
	}

	public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
		this.emailVerificationStatus = emailVerificationStatus;
	}

}
