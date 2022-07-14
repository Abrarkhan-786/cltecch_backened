package com.cltech.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cltech.hrms.bean.Education;
import com.cltech.hrms.bean.Employee;
import com.cltech.hrms.bean.Experience;
import com.cltech.hrms.bean.ResponseBean;
import com.cltech.hrms.service.impl.EmployeeServiceImpl;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController
@RequestMapping("/employee/")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;

	@PostMapping(path = "saveEmployee")
	@ResponseBody
	public ResponseBean saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
		
	}

	public ResponseBean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@PostMapping(path = "/getAllEmployee")
	public ResponseBean getAllEmployee() {
		return employeeService.getAllEmployee();

	}

	public ResponseBean getEmployeeById(Long id) {

		return null;
	}

	public ResponseBean getEmployeeByEducation(Education education) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseBean getEmployeeByEducation(Long educationId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseBean getEmployeeByExperience(Experience experience) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseBean getEmployeeByExperience(Long experienceId) {
		// TODO Auto-generated method stub
		return null;
	}
}
