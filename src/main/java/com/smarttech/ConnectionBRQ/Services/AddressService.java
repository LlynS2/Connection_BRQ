package com.smarttech.ConnectionBRQ.Services;

import com.smarttech.ConnectionBRQ.Model.DTO.AddressDTO;
import com.smarttech.ConnectionBRQ.Model.Entities.Address;

public interface AddressService {
	
	public AddressDTO findById(Long id);
	public Address    insertAddress(Address address);
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */