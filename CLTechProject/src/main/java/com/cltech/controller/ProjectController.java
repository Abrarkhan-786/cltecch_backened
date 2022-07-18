package com.cltech.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cltech.crud.bean.ResponseBean;

import com.cltech.model.ProjectModel;
import com.cltech.service.ProjectService;


@RestController
@RequestMapping("/cltech")
public class ProjectController {
	
	@Autowired
	ProjectService saveproject;
	
	@GetMapping("/project")
	public ResponseBean getProject() {
		ResponseBean rs = saveproject.getProjectList();
		return rs;
	}
	@PostMapping("/saveproject")
//	@RequestMapping(value = "/save", method = RequestMethod.POST)

	public ResponseBean saveProject (@RequestBody ProjectModel  e ) { 
		
		return    saveproject.saveProject(e);
	}
		
		@PutMapping("/updateproject")
		public ProjectModel updateProject(@RequestBody ProjectModel e) {
			return saveproject.updateProject(e);
		}
		
		@DeleteMapping("/project/{id}")
		public ResponseBean DeleteById(@PathVariable("id") Long id) {
			return saveproject.DeleteById(id);
		}
		
		@GetMapping("/project/{id}")
		public ResponseBean getProjectById(@PathVariable Long id) {
			return saveproject.getProjectById(id);
		}
	
	
}
