package chainofresp;

//Employee class representing a handler in the chain
public abstract class Employee {
	private Employee nextEmployee;

	public void setNextEmployee(Employee nextEmployee) {
		this.nextEmployee = nextEmployee;
	}

	public void processRequest(Request request) {
		if (canHandleRequest(request)) {
			handleRequest(request);
		} else if (nextEmployee != null) {
			nextEmployee.processRequest(request);
		}
	}

	protected abstract boolean canHandleRequest(Request request);

	protected abstract void handleRequest(Request request);
}