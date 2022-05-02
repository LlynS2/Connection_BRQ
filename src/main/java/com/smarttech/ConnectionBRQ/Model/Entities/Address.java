package com.smarttech.ConnectionBRQ.Model.Entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder

@Getter 
@Setter

@Data
@Entity(name = "TBL_ADDRESS")
public class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator( name = "address", sequenceName = "SQ_TBL_ADDRESS", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "address")
	private Long id;
	
	@Column(name = "cd_zipCode", nullable = false)
	private String zipCode;
	
	@Column(name = "ds_address", nullable = false)
	private String address;
	
	@Column(name = "cd_number", nullable = false)
	private String number;
	
	@Column(name = "ds_district", nullable = false)
	private String district;

	@Column(name = "ds_city", nullable = false)
	private String city;

	@Column(name = "ds_complement")
	private String complement;

	@Column(name = "ds_state", nullable = false)
	private String state;
	
	@Column(name = "ds_country", nullable = false)
	private String country;

	@ManyToOne
	@JoinColumn(name = "applicant_id", nullable = false)
	private Applicant applicant;
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */
