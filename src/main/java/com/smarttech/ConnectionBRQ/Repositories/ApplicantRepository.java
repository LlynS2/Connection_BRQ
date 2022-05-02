package com.smarttech.ConnectionBRQ.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smarttech.ConnectionBRQ.Model.Entities.Applicant;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
	
	public Optional<Applicant> findByCpf(String cpf);
	public Optional<Applicant> findByEmail(String email);
	public Optional<Applicant> findByUserNameContaining(String userName);

}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */