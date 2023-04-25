package command;

public class Client {
	public static void main(String[] args) {
		// Create the Receiver object
		Employee employee = new Employee("Shiva Priya", 123);

		// Create the Command objects
		AddEmployeeCommand addCommand = new AddEmployeeCommand(employee);
		RemoveEmployeeCommand removeCommand = new RemoveEmployeeCommand(employee);

		// Create the Invoker object
		EmployeeManagement management = new EmployeeManagement();

		// Set and execute the AddEmployeeCommand
		management.setCommand(addCommand);
		management.executeCommand();

		// Set and execute the RemoveEmployeeCommand
		management.setCommand(removeCommand);
		management.executeCommand();
	}
}
