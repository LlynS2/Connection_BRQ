package com.smarttech.ConnectionBRQ.Model.Entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import com.smarttech.ConnectionBRQ.Model.Entities.Enumeration.Gender;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder

@Getter 
@Setter

@Data
@Entity(name = "TBL_APPLICANT")
public class Applicant implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @SequenceGenerator(name = "applicant", sequenceName = "SQ_TBL_APPLICANT", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "applicant")
    private Long id;
	
	@Column (name = "cd_cpf", nullable = false)
	private String cpf;
	
	@Column (name = "name_applicant", nullable = false)
	private String userName;
	
	@Column (name = "ds_email", nullable = false)
	private String email;
	
	@Column (name = "ds_password", nullable = false)
	private String password;
	
	@Enumerated( EnumType.STRING )
	@Column(name = "ds_gender", nullable = false)
	private Gender gender;
	
	@Column(name = "dt_birthday", nullable = false)
	private Date birthday;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP )
	@Column(name = "dt_create", columnDefinition = "TIMESTAMP WITH TIME ZONE",updatable = false)
	private Date createDate;
	
	@OneToMany(mappedBy = "applicant")
	private List<Address> addresses;
	
	@OneToOne(mappedBy = "applicant")
    	@JoinColumn(name = "phone_id", referencedColumnName = "id")
    	private Telephone phone;
	
	@OneToMany(mappedBy = "applicant")
	private List<Skill> skills;
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */
