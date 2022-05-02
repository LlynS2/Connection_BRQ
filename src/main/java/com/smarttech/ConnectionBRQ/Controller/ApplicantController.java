package com.smarttech.ConnectionBRQ.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smarttech.ConnectionBRQ.Model.DTO.ApplicantCertificationDTO;
import com.smarttech.ConnectionBRQ.Model.DTO.ApplicantDTO;
import com.smarttech.ConnectionBRQ.Model.DTO.ApplicantSkillDTO;
import com.smarttech.ConnectionBRQ.Services.ApplicantService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/applicantController/applicant")
@Api(tags = "Applicant")
public class ApplicantController {
	
	@Autowired
	ApplicantService applicantService;
	
	@GetMapping("cpf/{cpf}")
	@ApiOperation(value = "Query by CPF")
	@ApiResponses(value = {
		           @ApiResponse(code = 200, message = "Ok Process"),
                   @ApiResponse(code = 400, message = "Bad request is received"),
                   @ApiResponse(code = 404, message = "Applicant Not Found"),
                   @ApiResponse(code = 500, message = "800000 - Server error")
      		     })
	public ResponseEntity<ApplicantDTO> 
	       findByCpf(@PathVariable("cpf") String cpf){	
		
		return new ResponseEntity<>
		          (applicantService.findByCpf(cpf), HttpStatus.OK);
	}
	
	@GetMapping("username/{userName}")
	@ApiOperation(value = "Query by Name")
	@ApiResponses(value = {
		           @ApiResponse(code = 200, message = "Ok Process"),
                   @ApiResponse(code = 400, message = "Bad request is received"),
                   @ApiResponse(code = 404, message = "Applicant Not Found"),
                   @ApiResponse(code = 500, message = "800000 - Server error")
      		     })
	public ResponseEntity<ApplicantDTO> 
	       findByUserName(@PathVariable("userName") String userName){	
		
		return new ResponseEntity<>
		           (applicantService.findByUserNameLike(userName), HttpStatus.OK);
	}

	@GetMapping("email/{email}")
	@ApiOperation(value = "Query by Email")
	@ApiResponses(value = {
    		       @ApiResponse(code = 200, message = "Ok Process"),
                   @ApiResponse(code = 400, message = "Bad request is received"),
                   @ApiResponse(code = 404, message = "Applicant Not Found"),
                   @ApiResponse(code = 500, message = "800000 - Server error")
      		     })
	public ResponseEntity<ApplicantDTO> 
	       findByEmail(@PathVariable("email") String email){	
		
		return new ResponseEntity<>
		          (applicantService.findByEmail(email), HttpStatus.OK);
	}
	
	/* 『 ✧„ 𝐑𝐄𝐌𝐀𝐑𝐊 ! 』
	 * 
	 * When the candidate is searched for by Skill, he will appear in the ranking of candidates 
	 * with a certificate first and then those who do not have certificates.
	 */
	
	@GetMapping("skillRanqueada/{skill}")
	@ApiOperation(value = "Query by skills ranked by certificate")
	@ApiResponses(value = {
    		       @ApiResponse(code = 200, message = "Ok Process"),
                   @ApiResponse(code = 400, message = "Bad request is received"),
                   @ApiResponse(code = 404, message = "Applicant Not Found"),
                   @ApiResponse(code = 500, message = "800000 - Server error")
      		     })
	public ResponseEntity<List<ApplicantSkillDTO>> 
	       findBySkill(@PathVariable("skill") String skill){	
		
		return new ResponseEntity<>
		          (applicantService.findBySkillsLike(skill), HttpStatus.OK);
	}
	
	@GetMapping("certification/{certification}")
	@ApiOperation(value = "Query by certificate")
	@ApiResponses(value = {
    		       @ApiResponse(code = 200, message = "Ok Process"),
                   @ApiResponse(code = 400, message = "Bad request is received"),
                   @ApiResponse(code = 404, message = "Applicant Not Found"),
                   @ApiResponse(code = 500, message = "800000 - Server error")
      		     })
	public ResponseEntity<List<ApplicantCertificationDTO>> 
	       findByCertifications(@PathVariable("certification") String certification){	
		
		return new ResponseEntity<>
		          (applicantService.findByCertificationsLike(certification), HttpStatus.OK);
	}
	
	@PostMapping()
	@ApiOperation(value = "Applicant registration")
	@ApiResponses(value = {
    		       @ApiResponse(code = 200, message = "Insert Ok", response = ApplicantDTO.class ),
                   @ApiResponse(code = 400, message = "Bad request is received"),
                   @ApiResponse(code = 500, message = "800000 - Server error")
                  })
	public ResponseEntity<ApplicantDTO> 
	       insertClient(@Valid @RequestBody ApplicantDTO applicantDTO){
		
		return new ResponseEntity<>
		           (applicantService.insertApplicant(applicantDTO), HttpStatus.OK);
	}
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */
