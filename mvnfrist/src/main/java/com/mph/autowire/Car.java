package com.mph.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
@Configuration
public class Car {

	@Value("BMW")
	private String name;
	@Value("x3")
	private String model;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Car(String name, String model) {
		super();
		this.name = name;
		this.model = model;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", model=" + model + "]";
	}

}