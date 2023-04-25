package Iterator;

import java.util.*;

//Define the Employee class
class Employee {
	private String name;
	private int id;

	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
}

//Define the Iterator interface
interface Iterator {
	boolean hasNext();

	Object next();
}

//Define the EmployeeCollection class that implements the Iterator interface
class EmployeeCollection implements Iterator {
	private List<Employee> employees;
	private int position;

	public EmployeeCollection(List<Employee> employees) {
		this.employees = employees;
		this.position = 0;
	}

	public boolean hasNext() {
		if (position < employees.size()) {
			return true;
		} else {
			return false;
		}
	}

	public Object next() {
		Employee employee = employees.get(position);
		position++;
		return employee;
	}
}

//Main class to test the implementation
public class IteratorExample {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Jeeva", 1));
		employees.add(new Employee("Jack", 2));
		employees.add(new Employee("Barbie", 3));

		EmployeeCollection employeeCollection = new EmployeeCollection(employees);
		while (employeeCollection.hasNext()) {
			Employee employee = (Employee) employeeCollection.next();
			System.out.println("Employee Name: " + employee.getName() + ", Employee ID: " + employee.getId());
		}
	}
}
