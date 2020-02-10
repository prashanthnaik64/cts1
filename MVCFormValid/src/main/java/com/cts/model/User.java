package com.cts.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

public class User {
	@Min(value = 100, message = "id can not be less than 100")
	   @Max(value = 999, message = "id can not be grater than 999")
	int Uid;
	
	@NotEmpty(message = "can't be null")
	String Name;
	
	@NotEmpty(message = "can't be null")
	
	@org.hibernate.validator.constraints.Email
	String Email;
	public User(int uid, String name, String email) {
		super();
		Uid = uid;
		Name = name;
		Email = email;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [Uid=" + Uid + ", Name=" + Name + ", Email=" + Email + "]";
	}
	public int getUid() {
		return Uid;
	}
	public void setUid(int uid) {
		Uid = uid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	

}

