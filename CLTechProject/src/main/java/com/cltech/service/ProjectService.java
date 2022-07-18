package com.cltech.service;

import com.cltech.crud.bean.*;
import com.cltech.model.ProjectModel;



import org.springframework.stereotype.Service;

@Service
public interface ProjectService {

	
	ResponseBean saveProject(ProjectModel project_model);
	ResponseBean getProjectList();
	
	
	ProjectModel updateProject(ProjectModel project_model);
	
	ResponseBean DeleteById(Long id);
	ResponseBean getProjectById(Long id);
	
	
	
}
