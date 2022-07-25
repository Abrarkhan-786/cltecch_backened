package com.cltech.hrms.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cltech.hrms.bean.ResponseBean;
import com.cltech.hrms.bean.user.Department;
import com.cltech.hrms.service.user.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	
	@Autowired
	@Qualifier("departmentServiceImpl")
	DepartmentService departmentService;

	@PostMapping("/saveDepartmentDetails")
	public ResponseBean addDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}

	@GetMapping("/getAllDepartment")
	public ResponseBean getAllDepartmentDetails() {
		return departmentService.getAllDepartment();
	}

	@GetMapping("/getDepartmentDetailsById/{ID}")
	public ResponseBean getById(@PathVariable("ID") Long id) {
		return departmentService.getDepartmentById(id);
	}

	@PutMapping("/updateDepartment")
	public ResponseBean updateDepartment(@RequestBody Department department) {
		return departmentService.updateDepartment(department);
	}

	

}
