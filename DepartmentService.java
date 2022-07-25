package com.cltech.hrms.service;

import com.cltech.hrms.bean.Department;
import com.cltech.hrms.bean.Education;
import com.cltech.hrms.bean.Employee;
import com.cltech.hrms.bean.Experience;
import com.cltech.hrms.bean.ResponseBean;

public interface DepartmentService {
	ResponseBean saveDepartment(Department employee);

	ResponseBean updateDepartment(Department employee);

	ResponseBean getAllDepartment();

	ResponseBean getDepartmentById(Long id);

	

}
