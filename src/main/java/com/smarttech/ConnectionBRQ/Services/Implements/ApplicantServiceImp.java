package com.smarttech.ConnectionBRQ.Services.Implements;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smarttech.ConnectionBRQ.Exception.NotFoundException;
import com.smarttech.ConnectionBRQ.Model.DTO.*;
import com.smarttech.ConnectionBRQ.Model.Entities.*;
import com.smarttech.ConnectionBRQ.Repositories.*;
import com.smarttech.ConnectionBRQ.Services.*;
import com.smarttech.ConnectionBRQ.Util.FormatEntityAndDTO;

@Service
public class ApplicantServiceImp implements ApplicantService{
	
	@Autowired
	ApplicantRepository applicantRepository;
	
	@Autowired
	SkillsRepository skillRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	TelephoneRepository telephoneRepository;
	
	@Autowired
	SkillsService skillService;
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	TelephoneService telephoneService;
	
	@Autowired
	FormatEntityAndDTO format;
	
	private Optional<Applicant> applicantOpt;
	
	private Applicant applicant;
	private Skill     skill;
	private Address   address;
	private Telephone phone;
	
	private List<Skill> 
		skills = new ArrayList<Skill>();
	private ApplicantSkillDTO 
		applicantSkillDTO = new ApplicantSkillDTO();
	private List<ApplicantSkillDTO> 
		applicantSkillsDTO = new ArrayList<ApplicantSkillDTO>();
	private ApplicantCertificationDTO 
		applicantCertificationDTO = new ApplicantCertificationDTO();
	private List<ApplicantCertificationDTO> 
		applicantCertificationsDTO = new ArrayList<ApplicantCertificationDTO>();
	
	
	@Override
	public ApplicantDTO findByCpf(String cpf) {
		
		return format.formatEntityTOApplicantDTO(getByCPF(cpf));
	}
	
	public Applicant getByCPF(String cpf) {
		
		applicantOpt = applicantRepository.findByCpf(cpf);
		
		return applicantOpt
			   .orElseThrow(() -> new NotFoundException 
					      (  " The CPF " + cpf
		                               + " is not registered in any application" )
			                      ) ;
	}

	public Applicant getById(Long id) {
		
		applicantOpt = applicantRepository.findById(id);
		
		return applicantOpt
			   .orElseThrow(() -> new NotFoundException 
					      (  " ID number: " + id
		                               + " not found " )
					      ) ;
	}

	@Override
	public ApplicantDTO findByUserNameLike(String userName) {
		
		return format.formatEntityTOApplicantDTO(getByUserName(userName));
	}
	
	public Applicant getByUserName(String userName) {
		
		applicantOpt = applicantRepository.findByUserNameContaining(userName);
		
		return applicantOpt
			   .orElseThrow(() -> new NotFoundException 
					      (  " The name  " + userName
					       + " is not registered in any application" )
					      ) ;
	}

	@Override
	public ApplicantDTO findByEmail(String email) {
		
		return format.formatEntityTOApplicantDTO(getByEmail(email));
	}
	
	public Applicant getByEmail(String email) {
		
		applicantOpt = applicantRepository.findByEmail(email);
		
		return applicantOpt
			   .orElseThrow(() -> new NotFoundException 
					      (  " The email " + email
					       + " is not registered in any application" )
                                              ) ;
	}
	
	@Override
	public List<ApplicantSkillDTO> findBySkillsLike( String FindSkill ) {
		
		
		applicantSkillDTO  = new ApplicantSkillDTO();
		applicantSkillsDTO = new ArrayList<ApplicantSkillDTO>();
		applicant = new Applicant();
		skills    = new ArrayList<Skill>();
		
		skills = skillRepository.findBySkillsContaining(FindSkill);
		
		skills
		  .stream()
		  	.forEach
		  		( skillAux -> {
		  		
			  		applicantSkillDTO = new ApplicantSkillDTO();
			  		
			  		applicant = getById(skillAux.getApplicant().getId());
			  		applicantSkillDTO.setUserName(applicant.getUserName());
			  		applicantSkillDTO.setCpf(applicant.getCpf());
			  		applicantSkillDTO.setEmail(applicant.getEmail());
			  		applicantSkillDTO.setSkills(skillAux.getSkills());
			  		applicantSkillDTO.setCertifications((skillAux.getCertifications()!=null ? 
			  						     skillAux.getCertifications() : "" ));
			  		applicantSkillDTO.setId(skillAux.getId());
			  		
			  		applicantSkillsDTO.add(applicantSkillDTO);
		  	    	});

		  applicantSkillsDTO = 
		     applicantSkillsDTO 
		      .stream()
		      .sorted((a1, a2) -> a2.getCertifications().compareTo(a1.getCertifications())) 
		      .collect(Collectors.toList());

		return applicantSkillsDTO;
	}

	@Override
	public List<ApplicantCertificationDTO> findByCertificationsLike(String FindCertification) {
		
		
		applicantCertificationDTO  = new ApplicantCertificationDTO();
		applicantCertificationsDTO = new ArrayList<ApplicantCertificationDTO>();
		applicant = new Applicant();
		skills    = new ArrayList<Skill>();
		
		skills = skillRepository.findByCertificationsContaining(FindCertification);
		
		skills
		  .stream()
		  	.forEach( skillAux -> {
		  		
		  		applicantCertificationDTO = new ApplicantCertificationDTO();
		  		
		  		applicant = getById(skillAux.getApplicant().getId());
		  		applicantCertificationDTO.setUserName(applicant.getUserName());
		  		applicantCertificationDTO.setCpf(applicant.getCpf());
		  		applicantCertificationDTO.setEmail(applicant.getEmail());
		  		applicantCertificationDTO.setCertifications(skillAux.getCertifications());
		  		applicantCertificationDTO.setId(skillAux.getId());
		  		
		  		applicantCertificationsDTO.add(applicantCertificationDTO);
		  	});

		  return applicantCertificationsDTO;
	}

	
	@Override
	public ApplicantDTO insertApplicant(ApplicantDTO applicantDTO) {
		
		List<Skill>   ListSkills  = new ArrayList<Skill>();
		List<Address> ListAddress = new ArrayList<Address>();
		
		applicant = format.formatApplicantDTOtoApplicant(applicantDTO);
		applicant.setId(null);
		applicant = applicantRepository.save(applicant);
		
		phone = format.formatTelephoneDTOtoTelephone(applicantDTO.getPhone());
		phone.setId(null);
		phone.setApplicant(applicant);
		phone = telephoneService.insertTelephone(phone);
		
		applicantDTO.getSkills()
		             .stream()
		              .forEach( skillAux -> {
		            	  
            				    skill = format.formatSkillsDTOtoSkills(skillAux);
            				    skill.setId(null);
            				    skill.setApplicant(applicant);
            				    skill = skillService.insertSkills(skill);
            				    
            				    ListSkills.add(skill);
                             });
		
		applicantDTO.getAddresses()
                     .stream()
                      .forEach( addressAux -> {
        				   
	        				   address = format.formatAddressDTOtoAddress(addressAux);
	        				   address.setId(null);
	        				   address.setApplicant(applicant);
	        				   address =  addressService.insertAddress(address);
	        				   
	        				   ListAddress.add(address);
	                         });
		
		applicantDTO = format.formatApplicantToApplicantDTO(applicant);
		
		applicantDTO.setPhone(format.formatTelephoneToTelephoneDTO(phone));
		applicantDTO.setSkills(format.formatSkillsToListSkillsDTO(ListSkills));
		applicantDTO.setAddresses(format.formatAddressToListAddressDTO(ListAddress));
		
		return applicantDTO;
	}
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */
