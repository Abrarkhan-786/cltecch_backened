package com.cltech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cltech.model.ProjectModel;


@Repository
public interface ProjectModelRepository extends JpaRepository<ProjectModel, Long> {
	
	

}
