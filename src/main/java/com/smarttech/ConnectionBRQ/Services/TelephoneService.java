package com.smarttech.ConnectionBRQ.Services;

import com.smarttech.ConnectionBRQ.Model.DTO.TelephoneDTO;
import com.smarttech.ConnectionBRQ.Model.Entities.Telephone;

public interface TelephoneService {
	
	public TelephoneDTO findById(Long id);
	public Telephone    insertTelephone(Telephone telephone);
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */