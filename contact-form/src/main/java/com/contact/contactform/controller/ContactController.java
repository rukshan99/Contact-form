package com.contact.contactform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.contactform.model.ContactFormDTO;
import com.contact.contactform.service.EmailService;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/sendEmail")
	public ResponseEntity<?> sendEmail(@RequestBody ContactFormDTO contactFormDTO) {
		
		emailService.send(contactFormDTO);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
