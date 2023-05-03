package com.mph.setterinj;

public class Car {

	private String name;
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