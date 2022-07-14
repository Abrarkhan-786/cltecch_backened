package com.cltech.hrms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cltech.hrms.bean.Education;
import com.cltech.hrms.bean.Employee;
import com.cltech.hrms.bean.Experience;
import com.cltech.hrms.bean.ResponseBean;
import com.cltech.hrms.bean.common.GridDataResponseBean;
import com.cltech.hrms.constant.MessageConstant;
import com.cltech.hrms.constant.Status;
import com.cltech.hrms.repository.EmployeeRepository;
import com.cltech.hrms.service.EmployeeService;

import lombok.Builder;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private static Logger LOGGER = LogManager.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public ResponseBean saveEmployee(Employee employee) {
		try {
			if (employee == null) {
				return ResponseBean.builder().status(Status.FAIL).message("Record is empty").build();
			}
			String skillString=String.join(", ",employee.getSkills().stream().map((skill)->skill.getSkillName()).collect(Collectors.toList()));
			employee.setTotalSkill(skillString);
			Employee employeeBean = employeeRepository.save(employee);
			return ResponseBean.builder().status(Status.SUCCESS).message("Record Added Succesfully").response(employeeBean).build();
		
		} catch(Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseBean.builder().status(Status.FAIL).message("Something went wrong").build();
		}

	}

		

	@Override
	public ResponseBean updateEmployee(Employee employee) {

		if (employee != null) {

			employeeRepository.save(employee);
			return ResponseBean.builder().status(Status.SUCCESS).message(MessageConstant.RECORD_CREATED)
					.response(employee).build();
		}
		return ResponseBean.builder().status(Status.FAIL).message(MessageConstant.RECORD_NULL).response(employee)
				.build();
	}

	@Override
	public ResponseBean getAllEmployee() {
		try {
			long count = employeeRepository.count();
			List<Employee> employees = employeeRepository.findAll();
			return ResponseBean.builder().status(Status.SUCCESS).response(GridDataResponseBean.<Employee>builder().totalRecords((int)count).rows(employees).build()).build();
		}catch(Exception e) {
			LOGGER.error(e.getMessage(),e);
			return ResponseBean.builder().status(Status.FAIL).message(MessageConstant.SOMETHING_WENT_WRONG).build();
					
		}
	}

	@Override
	public ResponseBean getEmployeeById(Long id) {

		Employee employee = employeeRepository.findById(id).get();

		return ResponseBean.builder().status(Status.SUCCESS)
				.response(employee).build();
	}

	@Override
	public ResponseBean getEmployeeByEducation(Education education) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseBean getEmployeeByEducation(Long educationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseBean getEmployeeByExperience(Experience experience) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseBean getEmployeeByExperience(Long experienceId) {
		// TODO Auto-generated method stub
		return null;
	}

}
