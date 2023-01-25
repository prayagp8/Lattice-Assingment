package com.la.controlller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.la.exception.HospitalException;
import com.la.exception.PatientException;
import com.la.exception.PsychiatristException;
import com.la.modal.Patient;
import com.la.service.PatientService;

@RestController
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/patient/{psychiatristId}")
	public ResponseEntity<Patient> registerPatient(@PathVariable Integer psychiatristId,@Valid @RequestBody Patient patient) throws PatientException, PsychiatristException{
		return new ResponseEntity<Patient>(patientService.registerPatient(psychiatristId,patient),HttpStatus.CREATED);
		
	}
	
}
