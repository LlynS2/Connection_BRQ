package com.smarttech.ConnectionBRQ.Controller.Exception;

import java.io.Serializable;
import java.util.Date;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor

@Getter 
@Setter
public class ApiError implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int    code;
	private String msg;
	private Date   date;
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */