package ems;

public class Client{
	public static void main(String[] args) {
		//Vehicle vehicle = new Car();
		Vehicle vehicle = new Bus();
		// vehicle vehicle = new Bus();
		Traveler traveler = new Traveler(vehicle);
		traveler. startJourney();
	}
}
