package command;

//Define the Invoker class
class EmployeeManagement {
 private Command command;

 public void setCommand(Command command) {
     this.command = command;
 }

 public void executeCommand() {
     command.execute();
 }
}