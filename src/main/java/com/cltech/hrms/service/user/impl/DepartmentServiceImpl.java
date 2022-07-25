package com.cltech.hrms.service.user.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cltech.hrms.bean.ResponseBean;
import com.cltech.hrms.bean.user.Department;
import com.cltech.hrms.constant.Status;
import com.cltech.hrms.repository.user.DepartmentRepository;
import com.cltech.hrms.service.user.DepartmentService;

@Service
@Qualifier("departmentServiceImpl")
public class DepartmentServiceImpl implements DepartmentService {

	private static Logger LOGGER = LogManager.getLogger(DepartmentServiceImpl.class);

	@Autowired
	private DepartmentRepository departmentRepo;

	@Override
	public ResponseBean saveDepartment(Department employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseBean updateDepartment(Department employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseBean getAllDepartment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseBean getDepartmentById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
