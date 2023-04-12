package com.extra;

class Emp {
	int empid;
	String empname = "Arun";
	//final int x=999;
	public Emp() {
		System.out.println("From Emp Constr");
	}

	public Emp(int empid) {

		this("Hello");
		this.empid = empid;

		System.out.println("From Emp Constr" + empid);
	}

	public Emp(String str) {

		System.out.println("From Emp Constr with str :" + str);
	}

	public  String getDetails() {
		return empid + " -- " + empname;
	}
	
	public void viewSalary() {
		System.out.println("View salary");
	}

}

class Manager extends Emp {
	String dept = "IT";

	public Manager() {
		super(500); // Used to invoke the base class constructor
		System.out.println("From Mgr Constr");
	}

	public Manager(String dept) {
		super();
		this.dept = dept; // to access the instance variable
	}

	public String getDetails() { // Overridding
		return super.getDetails() + "--" + dept;
	}
	
	public void assignProject() {
		System.out.println("Assinging Project");
	}

}

class Salary {

}

public class InMainClass {
	public static void main(String[] args) {
		Emp emp = new Emp();
		//System.out.println(em.getDetails());

		//Manager mgr = new Manager();
		//System.out.println(mgr.getDetails());
		
		Emp em = new Manager(); //Polymorphic object
		System.out.println(em.getDetails());
		
		em.viewSalary();
		//em.assignProject();
		
		if(emp instanceof Emp)
		{
			System.out.println("U r mgr");
		}
		else
		{
			System.out.println("U r emp");
		}
		
		
		
		
		
		
		
		
	}
}
