package chainofresp;

//Request class that holds information about the request to be processed
public class Request {
	private RequestType type;
	private int days;

	public Request(RequestType type, int days) {
		this.type = type;
		this.days = days;
	}

	public RequestType getType() {
		return type;
	}

	public int getDays() {
		return days;
	}
}