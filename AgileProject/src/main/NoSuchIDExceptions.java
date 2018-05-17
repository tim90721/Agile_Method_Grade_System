package main;

public class NoSuchIDExceptions extends Exception{

	private String message;
	
	public NoSuchIDExceptions(String ID) {
		message = "No ID named " + ID;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
