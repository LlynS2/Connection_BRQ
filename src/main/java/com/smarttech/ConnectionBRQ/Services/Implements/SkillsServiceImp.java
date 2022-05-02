package com.smarttech.ConnectionBRQ.Services.Implements;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smarttech.ConnectionBRQ.Exception.NotFoundException;
import com.smarttech.ConnectionBRQ.Model.DTO.SkillsDTO;
import com.smarttech.ConnectionBRQ.Model.Entities.Skill;
import com.smarttech.ConnectionBRQ.Repositories.SkillsRepository;
import com.smarttech.ConnectionBRQ.Services.SkillsService;
import com.smarttech.ConnectionBRQ.Util.FormatEntityAndDTO;

@Service
public class SkillsServiceImp implements SkillsService {
	
	@Autowired
	SkillsRepository skillsRepository;
	
	@Autowired
	FormatEntityAndDTO format;
	
	private Optional<Skill> skillsOpt;

	@Override
	public SkillsDTO findById(Long id) {
		
		return format.formatSkillsToSkillsDTO(getById(id));
	}
	
	public Skill getById(Long id) {
		
		skillsOpt = skillsRepository.findById(id);
		
		return skillsOpt.orElseThrow(() -> new NotFoundException(
                                         " There is no application with this ID " + id )
			                          ) ;
	}

	@Override
	public Skill insertSkills(Skill skills) {
		
		return skillsRepository.save(skills);
	}
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */