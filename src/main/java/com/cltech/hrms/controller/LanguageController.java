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

import com.cltech.hrms.bean.Language;
import com.cltech.hrms.bean.ResponseBean;
import com.cltech.hrms.service.impl.LanguageSerivceImpl;

@RestController
@RequestMapping("/employee")
public class LanguageController {

	@Autowired
	private LanguageSerivceImpl langService;

	@PostMapping("/saveLanguageDetails")
	public ResponseBean addLanguage(@RequestBody(required = false) Language lang) {
		return langService.addLanguage(lang);
	}

	@PutMapping("/updateLanguageDetails/{id}")
	public ResponseBean updatelanguage(@RequestBody Language lang) {
		return langService.updateLanguage(lang);
	}

	@DeleteMapping("/deleteLanguageDetails/{id}")
	public ResponseBean deleteById(@PathVariable int id) {
		return langService.deleteById(id);
	}

	@GetMapping("/getAllLanguageDetails")
	public ResponseBean getAllLanguageDetails() {
		return langService.getAllLanguageDetails();
	}

	@GetMapping("/getLanguageDetailsById/{id}")
	public ResponseBean getById(@PathVariable int id) {
		return langService.getById(id);
	}

}
