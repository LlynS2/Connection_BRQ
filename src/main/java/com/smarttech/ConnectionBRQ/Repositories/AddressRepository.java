package com.smarttech.ConnectionBRQ.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smarttech.ConnectionBRQ.Model.Entities.Address;

@Repository
public interface AddressRepository  extends JpaRepository<Address, Long> {

	public List<Address> findAllByApplicantId(Long applicantId);
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */