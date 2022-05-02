package com.smarttech.ConnectionBRQ.Util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smarttech.ConnectionBRQ.Model.DTO.*;
import com.smarttech.ConnectionBRQ.Model.Entities.*; 

@Component
public class FormatEntityAndDTO {
	
	@Autowired
	CheckExists<Applicant> checkApplicant;
	
	@Autowired
	CheckExists<Skill> checkSkills;
	
	@Autowired
	CheckExists<Telephone> checkTelephone;
	
	@Autowired
	CheckExists<Address> checkAddress;
	
	@Autowired
	CheckExists<ApplicantDTO> checkApplicantDTO;
	
	@Autowired
	CheckExists<SkillsDTO> checkSkillsDTO;
	
	@Autowired
	CheckExists<TelephoneDTO> checkTelephoneDTO;
	
	@Autowired
	CheckExists<AddressDTO> checkAddressDTO;
	
	private Address    address    = new Address(); 
	private AddressDTO addressDTO = new AddressDTO();
	
	private List<AddressDTO> ListAddressesDTO; 
	private List<Address>    ListAddresses;
	
	private Skill     skills    = new Skill(); 
	private SkillsDTO skillSDTO = new SkillsDTO();
	
	private List<SkillsDTO> ListSkillsDTO; 
	private List<Skill>     ListSkills;

	
	/*                        ⌠  𝐃𝐓𝐎 𝐭𝐨 𝐄𝐧𝐭𝐢𝐭𝐲   ⌡                            */
	
	public Applicant formatDTOtoApplicantEntity(ApplicantDTO applicantDTO){
		
		Applicant applicant = formatApplicantDTOtoApplicant(applicantDTO);
		
		if (checkSkillsDTO.listExists(applicantDTO.getSkills())){
			applicant.setSkills(formatSkillsDTOtoListSkills(applicantDTO.getSkills()));
		}
		
		if (checkAddressDTO.listExists(applicantDTO.getAddresses())) {
			applicant.setAddresses(formatAddressDTOtoListAddress(applicantDTO.getAddresses()));
		}
		
		if (checkTelephoneDTO.entityExists(applicantDTO.getPhone())) {
			applicant.setPhone(formatTelephoneDTOtoTelephone(applicantDTO.getPhone()));
		}
		
		return applicant;
	}
	
	public Applicant formatApplicantDTOtoApplicant(ApplicantDTO applicantDTO){
		
		Applicant applicant = new Applicant();
		
		applicant.setId(applicantDTO.getId());		
		applicant.setUserName(applicantDTO.getUserName());
		applicant.setBirthday(applicantDTO.getBirthday());
		applicant.setCpf(applicantDTO.getCpf());
		applicant.setGender(applicantDTO.getGender());
		applicant.setEmail(applicantDTO.getEmail());
		applicant.setPassword(applicantDTO.getPassword());
		
		return applicant;
	}
	
	public Telephone formatTelephoneDTOtoTelephone(TelephoneDTO telephoneDTO) {
		
		Telephone telephone = new Telephone();
		
		telephone.setId(telephoneDTO.getId());
		telephone.setPhone(telephoneDTO.getPhone());
		
		return telephone;
	}
	
	public Skill formatSkillsDTOtoSkills(SkillsDTO skillsDTO) {
		
		skills = new Skill();
		
		skills.setId(skillsDTO.getId());
		skills.setSkills(skillsDTO.getSkills());
		skills.setCertifications(skillsDTO.getCertifications());
		
		return skills;
	}
	
	public List<Skill> formatSkillsDTOtoListSkills(List<SkillsDTO> ListSkillSDTO) {
		
		skills     = new Skill();
		ListSkills = new ArrayList<Skill>();
		
		ListSkillSDTO
			 .stream()
			   .forEach
				 ( skillsAux -> { skills = new Skill();
										
		 			          skills.setId(skillsAux.getId());
		       				  skills.setSkills(skillsAux.getSkills());
		                                  skills.setCertifications(skillsAux.getCertifications());
		                          
		                                  ListSkills.add(skills);
			                         });
		return ListSkills;
	}
	
	public Address formatAddressDTOtoAddress(AddressDTO addressDTO) {
		
		address = new Address();
		
		address.setId(addressDTO.getId());
		address.setZipCode(addressDTO.getZipCode());
		address.setAddress(addressDTO.getAddress());
		address.setNumber(addressDTO.getNumber());
		address.setCity(addressDTO.getCity());
		address.setDistrict(addressDTO.getDistrict());
		address.setState(addressDTO.getState());
		address.setComplement(addressDTO.getComplement());
		address.setCountry(addressDTO.getCountry());
		
		return address;
	}
	
	public List<Address> formatAddressDTOtoListAddress(List<AddressDTO> ListAddresseSDTO) {
		
		address       = new Address();
		ListAddresses = new ArrayList<Address>();
		
		ListAddresseSDTO
			.stream()
	        	.forEach
	        		( addressAux -> { address = new Address();
													
            				          address.setId(addressAux.getId());
            				          address.setZipCode(addressAux.getZipCode());
            				          address.setAddress(addressAux.getAddress());
            				          address.setCity(addressAux.getCity());
            				          address.setDistrict(addressAux.getDistrict());
            				          address.setState(addressAux.getState());
            				          address.setComplement(addressAux.getComplement());											 
            				          address.setCountry(addressAux.getComplement());	

            				          ListAddresses.add(address);
					         });
		return ListAddresses;
    	}
	
	/*                        ⌠  𝐄𝐧𝐭𝐢𝐭𝐲 𝐭𝐨 𝐃𝐓𝐎  ⌡                          */
	
	public ApplicantDTO formatEntityTOApplicantDTO(Applicant applicant){
		
		ApplicantDTO applicantDTO = formatApplicantToApplicantDTO(applicant);
		
		if (checkSkills.listExists(applicant.getSkills())) {
			applicantDTO.setSkills(formatSkillsToListSkillsDTO(applicant.getSkills()));
		}
		
		if (checkAddress.listExists(applicant.getAddresses())) {
			applicantDTO.setAddresses(formatAddressToListAddressDTO(applicant.getAddresses()));
		}
		
		if (checkTelephone.entityExists(applicant.getPhone())) {
			applicantDTO.setPhone(formatTelephoneToTelephoneDTO(applicant.getPhone()));
		}
		
		 return applicantDTO;
	}
	
	public ApplicantDTO formatApplicantToApplicantDTO(Applicant applicant){
		
		ApplicantDTO applicantDTO = new ApplicantDTO();
		
		applicantDTO.setId(applicant.getId());
		applicantDTO.setUserName(applicant.getUserName());
		applicantDTO.setBirthday(applicant.getBirthday());
		applicantDTO.setCpf(applicant.getCpf());
		applicantDTO.setGender(applicant.getGender());
		applicantDTO.setEmail(applicant.getEmail());
		applicantDTO.setPassword(applicant.getPassword());
		
		return applicantDTO;
	}
	
	public TelephoneDTO formatTelephoneToTelephoneDTO(Telephone telephone) {
		
		TelephoneDTO telephoneDTO = new TelephoneDTO();
		
		telephoneDTO.setId(telephone.getId());
		telephoneDTO.setPhone(telephone.getPhone());
		
		return telephoneDTO;
	}
	
	public List<SkillsDTO> formatSkillsToListSkillsDTO(List<Skill> ListSkillS) {
		
		skillSDTO     = new SkillsDTO();
		ListSkillsDTO = new ArrayList<SkillsDTO>();
		
		ListSkillS
			.stream()
				.forEach
					( skillsAux -> { skillSDTO = new SkillsDTO();
										   
			  				  skillSDTO.setId(skillsAux.getId());
				       			  skillSDTO.setSkills(skillsAux.getSkills());
				                          skillSDTO.setCertifications(skillsAux.getCertifications());
				                          
				                          ListSkillsDTO.add(skillSDTO);
					                });
		return ListSkillsDTO;
	}
	
	public SkillsDTO formatSkillsToSkillsDTO(Skill skills) {
		
		skillSDTO = new SkillsDTO();
		
		skillSDTO.setId(skills.getId());
		skillSDTO.setSkills(skills.getSkills());
		skillSDTO.setCertifications(skills.getCertifications());
		
		return skillSDTO;
	}
	
	public List<AddressDTO> formatAddressToListAddressDTO(List<Address> ListAddresseS) {
		
		addressDTO       = new AddressDTO();
		ListAddressesDTO = new ArrayList<AddressDTO>();
		
		ListAddresseS
			.stream()
	        		.forEach
	            		    (addressAux -> { addressDTO = new AddressDTO();
											
						     addressDTO.setId(addressAux.getId());								
						     addressDTO.setZipCode(addressAux.getZipCode());
						     addressDTO.setAddress(addressAux.getAddress());
						     addressDTO.setNumber(addressAux.getNumber());
						     addressDTO.setCity(addressAux.getCity());
						     addressDTO.setDistrict(addressAux.getDistrict());
						     addressDTO.setState(addressAux.getState());
						     addressDTO.setComplement(addressAux.getComplement());											 
						     addressDTO.setCountry(addressAux.getCountry());		

						     ListAddressesDTO.add(addressDTO);
						   });
		return ListAddressesDTO;
	}
	
	public AddressDTO formatAddressToAddressDTO(Address address) {
		
		addressDTO = new AddressDTO();
		
		addressDTO.setId(address.getId());
		addressDTO.setZipCode(address.getZipCode());
		addressDTO.setAddress(address.getAddress());
		addressDTO.setNumber(address.getNumber());
		addressDTO.setCity(address.getCity());
		addressDTO.setDistrict(address.getDistrict());
		addressDTO.setState(address.getState());
		addressDTO.setComplement(address.getComplement());
		addressDTO.setCountry(address.getCountry());
		
		return addressDTO;
	}
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */
