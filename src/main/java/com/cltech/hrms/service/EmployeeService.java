package com.cltech.hrms.service;

import org.springframework.stereotype.Service;

import com.cltech.hrms.bean.Education;
import com.cltech.hrms.bean.Employee;
import com.cltech.hrms.bean.Experience;
import com.cltech.hrms.bean.ResponseBean;

public interface EmployeeService {

	ResponseBean saveEmployee(Employee employee);

	ResponseBean updateEmployee(Employee employee);

	ResponseBean getAllEmployee();

	ResponseBean getEmployeeById(Long id);

	ResponseBean getEmployeeByEducation(Education education);

	ResponseBean getEmployeeByEducation(Long educationId);

	ResponseBean getEmployeeByExperience(Experience experience);

	ResponseBean getEmployeeByExperience(Long experienceId);

}
