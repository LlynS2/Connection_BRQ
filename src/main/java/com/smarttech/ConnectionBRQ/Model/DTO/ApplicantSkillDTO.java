package com.smarttech.ConnectionBRQ.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder

@Getter 
@Setter

@Data
public class ApplicantSkillDTO {
	
	private Long   id;
	private String userName;
	private String cpf;
	private String email;
	private String skills;
	private String certifications;

}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */