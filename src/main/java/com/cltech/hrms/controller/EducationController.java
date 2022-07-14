package com.cltech.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cltech.hrms.bean.Education;
import com.cltech.hrms.bean.ResponseBean;
import com.cltech.hrms.service.impl.EducationServiceImpl;

@RestController
@RequestMapping("/employee")
public class EducationController {

	@Autowired
	private EducationServiceImpl eduService;

	@PostMapping("/saveEducationDetails")
	public ResponseBean addEducation(@RequestBody(required = false) Education ed) {
		System.out.println(ed + " controller");
		return eduService.addEducation(ed);
	}

	@PutMapping("/updateEducationDetails/{id}")
	public ResponseBean updateEduation(@RequestBody Education ed) {
		return eduService.updateEducation(ed);
	}

	@DeleteMapping("/deleteEducationDetails/{id}")
	public ResponseBean deleteById(@PathVariable int id) {
		return eduService.deleteById(id);
	}

	@GetMapping("/getAllEducatioDetails")
	public ResponseBean getAllEducatioDetails() {
		return eduService.getAllEducationDetails();
	}

	@GetMapping("/getEducationDetailsById/{id}")
	public ResponseBean getById(@PathVariable int id) {
		return eduService.getEducationDetailsById(id);
	}
}
