package com.smarttech.ConnectionBRQ.Util;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CheckExists<T> {
	
	public Boolean listExists(List<T> list) {
		return !list.isEmpty();
	}

	public Boolean entityExists(T entity) {
		return entity != null;
	}
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */