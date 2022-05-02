package com.smarttech.ConnectionBRQ.Services;

import com.smarttech.ConnectionBRQ.Model.DTO.SkillsDTO;
import com.smarttech.ConnectionBRQ.Model.Entities.Skill;


public interface SkillsService {

	public SkillsDTO findById(Long id);
	public Skill     insertSkills(Skill skills);
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */