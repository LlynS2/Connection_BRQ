package com.smarttech.ConnectionBRQ.Util;

import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class CheckVariables {
	
	public String checkNullString(String s) {
		return (s != null && !s.isEmpty()) ? s : "";
	}
	
	public Long checkNullLong(Long l) {
		return (l != null) ? l : 0L;
	}
	
	public Date checkNullDate(Date d) {
		return (d != null) ? d : new Date() ;
	}	
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */