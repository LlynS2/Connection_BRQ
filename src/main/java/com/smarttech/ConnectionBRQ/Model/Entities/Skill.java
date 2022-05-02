package com.smarttech.ConnectionBRQ.Model.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder

@Getter 
@Setter

@Data
@Entity( name = "TBL_SKILLS")
public class Skill implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @SequenceGenerator(name = "skills", sequenceName = "SQ_TBL_SKILLS", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skills")
    private Long id;
	
	@Column(name = "ds_skill", nullable = false)
	private String skills;
	
	@Column(name = "ds_certification")
	private String certifications;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP )
	@Column(name = "dt_create", columnDefinition = "TIMESTAMP WITH TIME ZONE",updatable = false)
	private Date createDate;
	
	@ManyToOne
	@JoinColumn(name = "candidato_id", nullable = false)
	private Applicant applicant;
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */
