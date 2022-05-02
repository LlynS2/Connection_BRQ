package com.smarttech.ConnectionBRQ.Model.DTO;

import javax.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder

@Getter 
@Setter

@Data
public class AddressDTO {
	
	private Long id;
	
	@NotBlank(message = "Informing your zip code is required") 
	private String zipCode;
	
	@NotBlank(message = "Informing your address is required") 
	private String address;
	
	@NotBlank(message = "Informing your residential number is required") 
	private String number;
	
	@NotBlank(message = "Informing your district is required") 
	private String district;
	
	@NotBlank(message = "Informing your city is required") 
	private String city;
	
	@NotBlank(message = "Informing your state is required") 
	private String state;
	
	@NotBlank(message = "Informing your country is required") 
	private String country;
	
	private String complement;
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */