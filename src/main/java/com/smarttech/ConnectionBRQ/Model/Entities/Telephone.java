package com.smarttech.ConnectionBRQ.Model.Entities;

import javax.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder

@Getter 
@Setter

@Data
@Entity(name = "TBL_TELEPHONE")
public class Telephone {
	
	@Id
    @SequenceGenerator(name = "telephone", sequenceName = "SQ_TBL_TELEPHONE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "telephone")
	private Long id;
	
	@Column(name = "nr_telephone", nullable = false)
	private String phone;

	@OneToOne
	@JoinColumn(name = "applicant_id", nullable = false)
	private Applicant applicant;
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */