package com.mph.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
@Configuration
public class User {
    @Value("vaish")
	private String userName;
	
	@Autowired
	private Car mycar;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	


	public User(String userName, Car mycar) {
		super();
		this.userName = userName;
		this.mycar = mycar;
	}





	


	public String getUserName() {
		return userName;
	}





	public void setUserName(String userName) {
		this.userName = userName;
	}





	public Car getMycar() {
		return mycar;
	}





	public void setMycar(Car mycar) {
		this.mycar = mycar;
	}





	@Override
	public String toString() {
		return "User [userName=" + userName + ", mycar=" + mycar + "]";
	}





	
}