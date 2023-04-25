package chainofresp;

//Example usage
public class Main {
 public static void main(String[] args) {
     // Create the chain of responsibility
     Employee supervisor = new Supervisor();
     Employee manager = new Manager();
     Employee director = new Director();

     supervisor.setNextEmployee(manager);
     manager.setNextEmployee(director);

     // Process requests
     supervisor.processRequest(new Request(RequestType.LEAVE, 2));
     supervisor.processRequest(new Request(RequestType.LEAVE, 7));
     supervisor.processRequest(new Request(RequestType.LEAVE, 14));
     supervisor.processRequest(new Request(RequestType.TRAVEL, 5));
 }
}