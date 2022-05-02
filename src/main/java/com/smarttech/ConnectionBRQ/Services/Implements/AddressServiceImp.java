package com.smarttech.ConnectionBRQ.Services.Implements;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smarttech.ConnectionBRQ.Exception.NotFoundException;
import com.smarttech.ConnectionBRQ.Model.DTO.AddressDTO;
import com.smarttech.ConnectionBRQ.Model.Entities.Address;
import com.smarttech.ConnectionBRQ.Repositories.AddressRepository;
import com.smarttech.ConnectionBRQ.Services.AddressService;
import com.smarttech.ConnectionBRQ.Util.FormatEntityAndDTO;

@Service
public class AddressServiceImp implements AddressService {
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	FormatEntityAndDTO format;
	
	private Optional<Address> addressOpt;

	@Override
	public AddressDTO findById(Long id) {
		
		return format.formatAddressToAddressDTO(getById(id));
	}
	
	public Address getById(Long id) {
		
		addressOpt = addressRepository.findById(id);
		
		return addressOpt.orElseThrow(() -> new NotFoundException(
                                         " There is no application with this ID " + id )
			                          ) ;
	}

	@Override
	public Address insertAddress(Address address) {
		
		return addressRepository.save(address);
	}
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */