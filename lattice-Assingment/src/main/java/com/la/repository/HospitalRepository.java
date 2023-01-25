package com.la.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.la.modal.Hospital;



public interface HospitalRepository extends JpaRepository<Hospital, Integer>{

}
