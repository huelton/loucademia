package com.br.loucademia.application.util;

public class Validation {

	public static void assertNotEmpty(Object obj) {
		if(obj instanceof String ) {
			String s = (String) obj;			
			if (StringUtils.isEmpty(s)) {
				throw new ValidationException("O texto nao pode ser nulo");
			}
		}
		
		if(obj == null) {
			throw new ValidationException("Valor nao pode ser nulo");
		}
	}
}
