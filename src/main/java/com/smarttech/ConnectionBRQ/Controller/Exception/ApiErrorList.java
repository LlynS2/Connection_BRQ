package com.smarttech.ConnectionBRQ.Controller.Exception;

import java.util.*;

import lombok.*;

@Getter 
@Setter
public class ApiErrorList extends ApiError {
	private static final long serialVersionUID = 1L;
	
	private List<String> errors;
	
	public ApiErrorList( int code, String msg, Date date, List<String> errors ) {
		super( code, msg, date );
		
		this.errors = errors;
	}
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */