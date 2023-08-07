package com.jsp.college.recruitment.exceptionHandling;

import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.jsp.college.recruitment.helper.ResponseStructure;

@ControllerAdvice
public class ExceptionHandler
{
	@org.springframework.web.bind.annotation.ExceptionHandler(UserDefinedException.class)
	public ResponseEntity<ResponseStructure<String>> handlingException(UserDefinedException ue)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage("");
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(ue.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,null,HttpStatus.BAD_REQUEST.value());
	}
}
