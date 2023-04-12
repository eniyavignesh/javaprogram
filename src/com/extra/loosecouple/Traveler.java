package com.extra.loosecouple;

public class Traveler {

	Vehicle vehicle =null;

	public Traveler(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void startJourney() {
		this.vehicle.move();
	}
}
