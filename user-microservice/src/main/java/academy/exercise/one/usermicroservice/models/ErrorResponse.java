package academy.exercise.one.usermicroservice.models;

import org.springframework.stereotype.Component;


@Component
public class ErrorResponse {
	private String input;
	private String message;
	private String service;
	
	private ErrorResponse() {
		
	}
	
	public ErrorResponse(String input,String message, String service) {
		super();
		this.input = input;
		this.message = message;
		this.service = service;
	}
	
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public ErrorResponse setMessage(String input,String message, String service) {
		this.input = input;
		this.message = message;
		this.service = service;
		return this;
	}
	
}