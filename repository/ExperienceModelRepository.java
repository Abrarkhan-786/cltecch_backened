package com.cltech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cltech.model.ExeperienceModel;

@Repository
public interface ExperienceModelRepository extends JpaRepository<ExeperienceModel, Long> {
	
	

}
