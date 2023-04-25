package proxy;

public class Client {
	public static void main(String[] args) {
		Employee employee = new EmployeeProxy("Shiva");
		employee.work();
		employee.work();
	}
}

/*

In this example, the Employee interface defines the work() method that all employees must implement. 
The RealEmployee class implements the Employee interface and represents the actual employee object that 
performs the work. The EmployeeProxy class also implements the Employee interface and acts as a proxy to 
the real employee object.

The EmployeeProxy class checks if the real employee object has been created. If it has, it simply delegates 
the work() method call to the real employee object. If it hasn't, it creates a new RealEmployee object and 
delegates the work() method call to it.

The Client class demonstrates how the proxy design pattern can be used to defer the creation of 
expensive objects until they are actually needed. In this example, the RealEmployee object is only created 
when the work() method is called for the first time. Subsequent calls to the work() method reuse the existing 
RealEmployee object, 
avoiding the time-consuming process of loading the employee details from the database again.

*/