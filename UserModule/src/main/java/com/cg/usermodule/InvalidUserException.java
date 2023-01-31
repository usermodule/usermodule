package com.nv.usermodule.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvalidUserException extends Exception{
	
	String fieldName;
	String msg;
	
	
	@Override
	public String toString() {
		return "UserException [fieldName=" + fieldName + ", msg=" + msg + "]";
	}	

	
}
