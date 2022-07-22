package com.cltech.service;

import com.cltech.model.ExeperienceModel;
import com.springbootmysql.crud.bean.ResponseBean;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface ExperienceService {

	List<ExeperienceModel> getAllExperience();
	ResponseBean saveExperience(ExeperienceModel experience_model);
	
	List<ExeperienceModel> getExperience();
	Optional<ExeperienceModel> findById(Long expId);
	ExeperienceModel updateExperience(ExeperienceModel e);
	ResponseBean deleteById(Long id);
	ResponseBean getExperienceDetailsById(Long id);
	
	
}
