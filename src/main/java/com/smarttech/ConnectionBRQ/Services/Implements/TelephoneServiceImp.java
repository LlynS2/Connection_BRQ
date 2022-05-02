package com.smarttech.ConnectionBRQ.Services.Implements;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smarttech.ConnectionBRQ.Exception.NotFoundException;
import com.smarttech.ConnectionBRQ.Model.DTO.TelephoneDTO;
import com.smarttech.ConnectionBRQ.Model.Entities.Telephone;
import com.smarttech.ConnectionBRQ.Repositories.TelephoneRepository;
import com.smarttech.ConnectionBRQ.Services.TelephoneService;
import com.smarttech.ConnectionBRQ.Util.FormatEntityAndDTO;

@Service
public class TelephoneServiceImp implements TelephoneService {
	
	@Autowired
	TelephoneRepository telephoneRepository;
	
	@Autowired
	FormatEntityAndDTO format;
	
	private Optional<Telephone> telephoneOpt;

	@Override
	public TelephoneDTO findById(Long id) {
		
		return format.formatTelephoneToTelephoneDTO(getById(id));
	}
	
	public Telephone getById(Long id) {
		
		telephoneOpt = telephoneRepository.findById(id);
		
		return telephoneOpt.orElseThrow(() -> new NotFoundException(
				                            " There is no application with this ID " + id )
										) ;
	}
	
	@Override
	public Telephone insertTelephone(Telephone telephone) {
		
		return telephoneRepository.save(telephone);
	}
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */