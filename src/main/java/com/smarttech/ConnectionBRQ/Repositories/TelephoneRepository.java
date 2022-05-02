package com.smarttech.ConnectionBRQ.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smarttech.ConnectionBRQ.Model.Entities.Telephone;

@Repository
public interface TelephoneRepository extends JpaRepository<Telephone, Long> {
	
	public Optional<Telephone> findByApplicantId(Long applicantId);
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */
