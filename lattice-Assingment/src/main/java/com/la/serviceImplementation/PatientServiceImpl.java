package com.la.serviceImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.la.exception.PatientException;
import com.la.exception.PsychiatristException;
import com.la.modal.Patient;
import com.la.modal.Psychiatrist;
import com.la.repository.PatientRepository;
import com.la.repository.PsychiatristRepository;
import com.la.service.PatientService;



@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private PsychiatristRepository psychiatristRepository;
	

	@Override
	public Patient registerPatient(Integer psychiatristId, Patient patient)
			throws PatientException, PsychiatristException {
		if(patient==null) {
			throw new PatientException("Patient not saved");
		}else {
			Optional<Psychiatrist> psyOptional=psychiatristRepository.findById(psychiatristId);
			if(psyOptional.isPresent()) {
				Psychiatrist psychiatrist=psyOptional.get();
				psychiatrist.setPatients(new ArrayList<>());
				psychiatrist.getPatients().add(patient);
				patient.setPsychiatrist(psychiatrist);
				return patientRepository.save(patient);
			}else {
				throw new PsychiatristException("psychiatrist is not found");
			}
		}
	}

}
