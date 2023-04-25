package chainofresp;

//Concrete Employee classes that represent different levels of authority in the chain
class Supervisor extends Employee {
	@Override
	protected boolean canHandleRequest(Request request) {
		return request.getType() == RequestType.LEAVE && request.getDays() <= 3;
	}

	@Override
	protected void handleRequest(Request request) {
		System.out
				.println("Supervisor approved a " + request.getType() + " request for " + request.getDays() + " days.");
	}
}

class Manager extends Employee {
	@Override
	protected boolean canHandleRequest(Request request) {
		return request.getType() == RequestType.LEAVE && request.getDays() <= 10;
	}

	@Override
	protected void handleRequest(Request request) {
		System.out.println("Manager approved a " + request.getType() + " request for " + request.getDays() + " days.");
	}
}

class Director extends Employee {
	@Override
	protected boolean canHandleRequest(Request request) {
		return request.getType() == RequestType.LEAVE && request.getDays() <= 30;
	}

	@Override
	protected void handleRequest(Request request) {
		System.out.println("Director approved a " + request.getType() + " request for " + request.getDays() + " days.");
	}
}
