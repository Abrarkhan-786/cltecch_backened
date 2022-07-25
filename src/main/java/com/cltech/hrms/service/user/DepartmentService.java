package com.cltech.hrms.service.user;

import com.cltech.hrms.bean.ResponseBean;
import com.cltech.hrms.bean.user.Department;

public interface DepartmentService {
	
	ResponseBean saveDepartment(Department employee);
	ResponseBean updateDepartment(Department employee);
	ResponseBean getAllDepartment();
	ResponseBean getDepartmentById(Long id);

	

}
