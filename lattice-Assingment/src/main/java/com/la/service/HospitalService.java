package com.la.service;

import java.util.List;
import java.util.Map;

import com.la.exception.HospitalException;
import com.la.modal.Hospital;
import com.la.modal.HospitalDetails;



public interface HospitalService {
	public Hospital createHospital(Hospital hospital) throws HospitalException;
	public List<Hospital> getAllHospitals() throws HospitalException;
	public HospitalDetails getHospitalDetails(Integer hospitalId) throws HospitalException;
}


