package com.br.loucademia.application.util;

import javax.ejb.ApplicationException;

@ApplicationException
public class ValidationException extends RuntimeException {

	public ValidationException(String message) {
		super(message);
	}
	
}
