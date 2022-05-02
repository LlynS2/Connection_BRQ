package com.smarttech.ConnectionBRQ.Model.DTO;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder

@Getter 
@Setter

@Data
public class SkillsDTO {
	
	private Long id;
	
	@NotBlank(message = "Add your Skills for better results") 
	private String skills;
	
	private String certifications;
	
	private Date createDate;
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */