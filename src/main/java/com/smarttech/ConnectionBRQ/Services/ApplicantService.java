package com.smarttech.ConnectionBRQ.Services;

import java.util.List;

import com.smarttech.ConnectionBRQ.Model.DTO.ApplicantCertificationDTO;
import com.smarttech.ConnectionBRQ.Model.DTO.ApplicantDTO;
import com.smarttech.ConnectionBRQ.Model.DTO.ApplicantSkillDTO;

public interface ApplicantService {
	
	public ApplicantDTO findByCpf(String cpf);
	public ApplicantDTO findByUserNameLike(String userName);
	public ApplicantDTO findByEmail(String email);
	
	public List<ApplicantSkillDTO>         findBySkillsLike(String FindSkill);
	public List<ApplicantCertificationDTO> findByCertificationsLike(String FindCertification);
	
	public ApplicantDTO insertApplicant( ApplicantDTO applicantDTO );
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */