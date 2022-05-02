package com.smarttech.ConnectionBRQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.smarttech.ConnectionBRQ.Util.BuilderApplicantTest;

@SpringBootApplication
public class ConnectionBrqApplication  implements CommandLineRunner {

	@Autowired
	BuilderApplicantTest builderApplicant;
	
	public static void main(String[] args) {
		
		SpringApplication.run(ConnectionBrqApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		
		System.out.println("initialize the tables");
		builderApplicant.BuilderAll();
	}
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */