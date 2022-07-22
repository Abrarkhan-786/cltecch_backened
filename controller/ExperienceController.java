package com.cltech.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cltech.model.ExeperienceModel;
import com.cltech.service.impl.ExperienceServiceImpl;
import com.springbootmysql.crud.bean.ResponseBean;
import com.springbootmysql.crud.constant.Status;

@RestController
@RequestMapping("/cltech")
public class ExperienceController {

	@Autowired
	private ExperienceServiceImpl experienceService;

	@GetMapping("/experience")
	public List<ExeperienceModel> getExperience() {
		// experienceService.getAllExperience();
		return experienceService.getAllExperience();
	}

	// This is for JOB Title API
	@GetMapping("/experience/{expId}")
	public Optional<ExeperienceModel> getExperience(@PathVariable("expId") Long expId) {
		return experienceService.findById(expId);
	}

	@PutMapping("/experience")
	public ExeperienceModel updateExperience(@RequestBody ExeperienceModel e) {
		return experienceService.updateExperience(e);
	}

	@DeleteMapping("/experience/{id}")
	public ResponseBean deleteById(@PathVariable("id") Long id) {
		return experienceService.deleteById(id);
	}

	@GetMapping("/getExperienceDetailsById/{id}")
	public ResponseBean getById(@PathVariable Long id) {
		return experienceService.getExperienceDetailsById(id);
	}

	@PostMapping("/experience")
	public ResponseBean saveExperience(@RequestBody ExeperienceModel e) {
//		System.out.println("experience model = " + e);
		if (e == null) {
			return ResponseBean.builder().status(Status.FAIL).message("Data Is Null").build();
		} else {
			experienceService.saveExperience(e);
		}

		return ResponseBean.builder().status(Status.SUCCESS).message("Record Added Succesfully").response(e).build();
	}

}
