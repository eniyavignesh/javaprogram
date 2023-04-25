package command;

class RemoveEmployeeCommand implements Command {
    private Employee employee;

    public RemoveEmployeeCommand(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void execute() {
        // Code to remove the employee from the system
        System.out.println("Removing employee " + employee.getName() + " from the system...");
    }
}
