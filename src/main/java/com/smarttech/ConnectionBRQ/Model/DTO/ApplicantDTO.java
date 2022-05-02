package com.smarttech.ConnectionBRQ.Model.DTO;

import java.util.*;
import javax.validation.*;
import javax.validation.constraints.*;

import lombok.*;

import org.hibernate.validator.constraints.br.CPF;

import com.smarttech.ConnectionBRQ.Model.Entities.Enumeration.Gender;

@AllArgsConstructor
@NoArgsConstructor
@Builder

@Getter 
@Setter

@Data
public class ApplicantDTO {
	
	private Long id;
	
	@CPF(message = "CPF is required for candidate validation")
	private String cpf;
	
	@NotBlank(message = "Enter your name to candidacy") 
	private String userName;
	
	@Email(message = "Enter your email ") 
	private String email;
	
	@NotBlank(message = "Enter a password to access your registration") 
	private String password;
	
	private Gender gender;
	
	@Past(message = "Enter your age") 
	private Date birthday;
	
	@Valid
	private TelephoneDTO phone;
	
	@Valid
	private List<AddressDTO> addresses;
	
	@Valid
	private List<SkillsDTO> skills;
	
	private Date createDate;
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */