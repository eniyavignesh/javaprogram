package com.extra.loosecouple;

public class Client {

	public static void main(String[] args) {
		
		//Vehicle vehicle = new Car();
		Vehicle vehicle = new Bike();
		//Vehicle vehicle = new Bus();
		Traveler  traveler = new Traveler(vehicle);
		traveler.startJourney();

	}

}
