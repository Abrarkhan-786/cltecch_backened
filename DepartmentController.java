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

import com.cltech.hrms.bean.Department;
import com.cltech.hrms.bean.Education;
import com.cltech.hrms.bean.ResponseBean;
import com.cltech.hrms.service.impl.DepartmentServiceImpl;

@RestController
@RequestMapping("/employee/")
public class DepartmentController {
	@Autowired
	DepartmentServiceImpl departService;

	@PostMapping("/saveDepartmentDetails")
	public ResponseBean addDepartment(@RequestBody(required = false) Department dep) {
		System.out.println(dep + " controller");
		return departService.addDepartment(dep);
	}

	@GetMapping("/getAllDepartmentDetails")
	public ResponseBean getAllDepartmentDetails() {
		return departService.getAllDepartmentDetails();
	}

	@GetMapping("/getDepartmentDetailsById/{id}")
	public ResponseBean getById(@PathVariable int id) {
		return departService.getDepartmentDetailsById(id);
	}

	@PutMapping("/updateDepartmentDetails/{id}")
	public ResponseBean updateDepartment(@RequestBody Department dep) {
		return departService.updateDepartmentDetails(dep);
	}

	@DeleteMapping("/deleteDepartmentDetails/{id}")
	public ResponseBean deleteById(@PathVariable int id) {
		return departService.deleteById(id);
	}

}
