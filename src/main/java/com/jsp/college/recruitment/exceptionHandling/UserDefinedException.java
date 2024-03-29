package com.jsp.college.recruitment.exceptionHandling;

public class UserDefinedException extends RuntimeException
{
	private String message;
	
	public UserDefinedException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
