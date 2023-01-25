package com.la.controlller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.la.exception.HospitalException;
import com.la.modal.Hospital;
import com.la.modal.HospitalDetails;
import com.la.modal.Psychiatrist;
import com.la.repository.HospitalRepository;
import com.la.repository.PsychiatristRepository;
import com.la.service.HospitalService;

@RestController
public class HospitalController {
	@Autowired
	private HospitalService hospitalService;
	
	@GetMapping("/hospital")
	public ResponseEntity<List<Hospital>> getAllHospitals() throws HospitalException{
		return new ResponseEntity<List<Hospital>>(hospitalService.getAllHospitals(),HttpStatus.OK);
	}
	
	@GetMapping("/hospital/{hospitalId}")
	public ResponseEntity<HospitalDetails> getHospitalDetails(@PathVariable Integer hospitalId) throws HospitalException{
		return new ResponseEntity<HospitalDetails>(hospitalService.getHospitalDetails(hospitalId),HttpStatus.OK);
	}
	
	@PostMapping("/hospital")
	public ResponseEntity<Hospital> createHospital(@RequestBody Hospital hospital) throws HospitalException{
		return new ResponseEntity<Hospital>(hospitalService.createHospital(hospital),HttpStatus.OK);
	}
}