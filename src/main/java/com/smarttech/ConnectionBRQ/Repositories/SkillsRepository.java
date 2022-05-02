package com.smarttech.ConnectionBRQ.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smarttech.ConnectionBRQ.Model.Entities.Skill;

@Repository
public interface SkillsRepository extends JpaRepository<Skill, Long> {
	
	public List<Skill> findAllByApplicantId(Long applicantId);
	public List<Skill> findBySkillsContaining(String skills);
	public List<Skill> findByCertificationsContaining(String certifications);

}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */