package com.smarttech.ConnectionBRQ.Model.DTO;

import javax.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder

@Getter 
@Setter

@Data
public class TelephoneDTO {
	
	private Long id;
	
	@NotBlank( message = "Contact is required for return" )
	private String phone;
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */