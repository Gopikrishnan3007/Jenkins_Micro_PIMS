package com.gopi.restapp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gopi.restapp.model.Login;
import com.gopi.restapp.model.LogisticManager;
import com.gopi.restapp.model.OperationManager;
import com.gopi.restapp.model.VesselOperator;
import com.gopi.restapp.service.EmailService;
import com.gopi.restapp.service.LogisticManagerService;
import com.gopi.restapp.service.OperationManagerService;
import com.gopi.restapp.service.VesselOperatorService;

import jakarta.mail.MessagingException;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LogisticManagerService logisticManagerService;

	@Autowired
	private OperationManagerService operationManagerService;

	@Autowired
	private VesselOperatorService vesselOperatorService;


	@Autowired
    private EmailService emailService;
 
    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendEmail(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String body
    ) {
        try {
 
            emailService.sendEmail(to, subject, body);
            return ResponseEntity.ok("Email sent successfully");
        } catch (MessagingException | IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email: " + e.getMessage());
        }
    } 


	@PostMapping
	public Object login(@RequestBody Login login) {

		String userName = login.getUserName();
		String password = login.getPassword();

		// Authenticate LogisticManager
		List<LogisticManager> logisticManagers = logisticManagerService.getAllLogisticManagers();
		for (LogisticManager logisticManager : logisticManagers) {
			if (logisticManager.getUserName().equals(userName) && logisticManager.getPassword().equals(password)) {
				return logisticManager;
			}
		}

		// Authenticate OperationManager
		List<OperationManager> operationManagers = operationManagerService.getAllOperationManagers();
		for (OperationManager operationManager : operationManagers) {
			if (operationManager.getUserName().equals(userName) && operationManager.getPassword().equals(password)) {
				return operationManager;
			}
		}

		// Authenticate vesselOperators
		List<VesselOperator> vesselOperators = vesselOperatorService.getAllVesselOperators();
		for (VesselOperator vesselOperator : vesselOperators) {
			if (vesselOperator.getUserName().equals(userName) && vesselOperator.getPassword().equals(password)) {
				return vesselOperator;
			}
		}


		return "Login failed: Invalid email or password";
	}

	
	

}
