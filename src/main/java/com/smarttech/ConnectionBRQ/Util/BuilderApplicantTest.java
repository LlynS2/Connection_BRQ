package com.smarttech.ConnectionBRQ.Util;

import java.text.SimpleDateFormat;

import java.util.*;
import org.apache.logging.log4j.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smarttech.ConnectionBRQ.Model.Entities.*;
import com.smarttech.ConnectionBRQ.Model.Entities.Enumeration.*;
import com.smarttech.ConnectionBRQ.Repositories.*;

@Component
public class BuilderApplicantTest {
	
	@Autowired
	ApplicantRepository applicantRepository;
	
	@Autowired
	SkillsRepository skillsRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	TelephoneRepository telephoneRepository;
	
	SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy"); 
	
	private static final Logger logger = LogManager.getLogger(CheckVariables.class);
	
	Applicant applicantTest = new Applicant();
	Telephone phone         = new Telephone();
	Skill     skills        = new Skill();
	Address   address       = new Address();
	
	List<Skill>   ListSkills    = new ArrayList<Skill>();
	List<Address> ListAddresses = new ArrayList<Address>();
	
	Optional<Applicant> applicantOpt;
	
	/*                           𝐌𝐘 𝐓𝐄𝐒𝐓 𝐀𝐏𝐏𝐋𝐈𝐂𝐀𝐍𝐓                                   */
	
	public void BuilderAll() {
	
		applicantRepository.save(builderApplicant());
		
		applicantOpt  = applicantRepository.findByCpf( "254.153.742-93" );
		applicantTest = applicantOpt.get();

		builderAddress( applicantTest,true );
		builderSkills( applicantTest,true );
		builderTelephone( applicantTest,true );
		
	}
	
	public Applicant builderApplicant() {
		
		try { applicantTest.setBirthday(date.parse("11/12/2004"));
		
		    } catch (Exception e) {
		      logger.error("Birthday Error : {}", e.toString());
		}
		
		applicantTest.setUserName("Kimberlyn O'Brian");
		applicantTest.setCpf("254.153.742-93");
		applicantTest.setGender(Gender.Female);
		applicantTest.setEmail( "Kimberlyn@gmail.com");
		applicantTest.setPassword("Papillon");
		
		return applicantTest;
	}
	
	public List<Skill> builderSkills( Applicant applicant , Boolean Test ){
		
		skills = new Skill();

		skills.setSkills("Scrum");
		skills.setCertifications("Course Scrum - Udemy");
		skills.setApplicant(applicantTest);

		ListSkills.add(skills);

		if( Test ) {
			skillsRepository.save(skills);
		}

		skills = new Skill();

		skills.setSkills("Java");
		skills.setCertifications("Course Java Complete - Udemy");
		skills.setApplicant(applicantTest);

		ListSkills.add(skills);

		if( Test ) {
			skillsRepository.save(skills);
		}

		skills = new Skill();

		skills.setSkills("JavaScript");
		skills.setApplicant(applicantTest);

		ListSkills.add(skills);

		if( Test ) {
			skillsRepository.save(skills);
		}

		return ListSkills;
	}
	
	public Telephone builderTelephone( Applicant applicant , Boolean Test ) {
		
		phone.setPhone("(13)98801-4599");
		phone.setApplicant(applicantTest);
		
		if( Test ) {
			telephoneRepository.save(phone);
		}
		
		return phone;
	}
	
	public List<Address> builderAddress( Applicant applicant , Boolean Test ){
	
		address= new Address();
		
		address.setCountry("Brasil");
		address.setState("São Paulo");
		address.setCity("Santos");
		address.setDistrict("Gonzaga");
		address.setAddress("Condomínio Edifício Gisela - R. Pasteur, Gonzaga, Santos - SP");
		address.setNumber("55");
		address.setZipCode("11060-440");
		address.setComplement("Apartamento 15");
		address.setApplicant(applicantTest);
		
		ListAddresses.add(address);
		
		if( Test ) {
		    addressRepository.save(address);
		}

		address= new Address();
		
		address.setCountry("Brasil");
		address.setState("São Paulo");
		address.setCity("São Vicente");
		address.setDistrict("Centro");
		address.setAddress("Casa VilaBela - R. PraiaAzul, Centro, São Vicente - SP");
		address.setNumber("55");
		address.setZipCode("98745-987");
		address.setComplement("Casa do Fundo");
		address.setApplicant(applicantTest);
		
		ListAddresses.add(address);
		
		if( Test ) {
			addressRepository.save(address);
		}
		
		return ListAddresses;
	}
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */