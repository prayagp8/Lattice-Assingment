package com.la.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.la.modal.Psychiatrist;


public interface PsychiatristRepository extends JpaRepository<Psychiatrist, Integer>{

}
