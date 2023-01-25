package com.la.serviceImplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.la.exception.HospitalException;
import com.la.modal.Hospital;
import com.la.modal.HospitalDetails;
import com.la.modal.Psychiatrist;
import com.la.modal.PsychiatristDetails;
import com.la.repository.HospitalRepository;
import com.la.service.HospitalService;



@Service
public class HospitalServiceImpl implements HospitalService{
	@Autowired
	private HospitalRepository hospitalRepository;

	@Override
	public List<Hospital> getAllHospitals() throws HospitalException {
		List<Hospital> hospitals=hospitalRepository.findAll();
		if(hospitals.size()==0) {
			throw new HospitalException("hospital not found");
		}else {
			return hospitals;
		}
	}

	@Override
	public HospitalDetails getHospitalDetails(Integer hospitalId) throws HospitalException {

		HospitalDetails hospitalDetails = new HospitalDetails();
		Hospital hospital = hospitalRepository.findById(hospitalId).get();
		if(hospital==null) {
			throw new HospitalException("hospital not found");
		}else {
			List<Psychiatrist> psychiatrists = hospital.getPsychiatrists();
			int totalPatients = 0;
			List<PsychiatristDetails> psychiatristDetailsList=new ArrayList<>();

			for (Psychiatrist psychiatrist : psychiatrists) {
				totalPatients += psychiatrist.getPatients().size();
				PsychiatristDetails psychiatristDetails=new PsychiatristDetails();
				psychiatristDetails.setId(psychiatrist.getId());
				psychiatristDetails.setName(psychiatrist.getName());
				psychiatristDetails.setPatientCount(psychiatrist.getPatients().size());
				psychiatristDetailsList.add(psychiatristDetails);


			}

			hospitalDetails.setName(hospital.getName());
			hospitalDetails.setPsychiatristDetails(psychiatristDetailsList);
			hospitalDetails.setPsychiatristCount(psychiatrists.size());
			hospitalDetails.setPatientsCount(totalPatients);
		}
		return hospitalDetails;
	}

	@Override
	public Hospital createHospital(Hospital hospital) throws HospitalException {
		Hospital savedHospital=hospitalRepository.save(hospital);
		return savedHospital;
	}

}

