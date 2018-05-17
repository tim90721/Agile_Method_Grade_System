package main;

public class NoSuchCommandExceptions extends Exception{

	private String message;
	
	public NoSuchCommandExceptions(String command) {
		message = "No command named" + command;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
