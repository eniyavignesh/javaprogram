package command;

//Define the concrete Command classes
class AddEmployeeCommand implements Command {
 private Employee employee;

 public AddEmployeeCommand(Employee employee) {
     this.employee = employee;
 }

 @Override
 public void execute() {
     // Code to add the employee to the system
     System.out.println("Adding employee " + employee.getName() + " to the system...");
 }
}

