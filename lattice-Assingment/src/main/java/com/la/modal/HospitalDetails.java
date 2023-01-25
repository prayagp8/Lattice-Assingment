package com.la.modal;

import java.util.List;

import lombok.Data;

@Data
public class HospitalDetails {
	private String name;
	private Integer psychiatristCount;
	private Integer patientsCount;
	private List<PsychiatristDetails> PsychiatristDetails;
}

