package com.la.service;

import java.util.List;

import com.la.exception.HospitalException;
import com.la.exception.PsychiatristException;
import com.la.modal.Psychiatrist;



public interface PsychiatristService {
	public List<Psychiatrist> getAllPsychiatrist() throws PsychiatristException;
	public Psychiatrist addPsychiatrist(Integer hospitalId,Psychiatrist psychiatrist) throws PsychiatristException,HospitalException;
}
