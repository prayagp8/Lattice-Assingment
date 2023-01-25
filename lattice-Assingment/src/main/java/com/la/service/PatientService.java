package com.la.service;

import com.la.exception.PatientException;
import com.la.exception.PsychiatristException;
import com.la.modal.Patient;

public interface PatientService {
	public Patient registerPatient(Integer psychiatristId, Patient patient) throws PatientException,PsychiatristException;
}
