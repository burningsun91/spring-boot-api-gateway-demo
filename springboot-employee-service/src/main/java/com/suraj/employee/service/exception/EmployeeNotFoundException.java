package com.suraj.employee.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{
	
	public EmployeeNotFoundException(String exception) {
		super(exception);
	}

}
