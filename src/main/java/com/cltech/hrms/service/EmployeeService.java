package com.cltech.hrms.service;

import com.cltech.hrms.bean.Employee;
import com.cltech.hrms.bean.ResponseBean;
import com.cltech.hrms.bean.common.DataTableRequestBean;
import com.cltech.hrms.bean.common.GridDatatableRequestBean;

public interface EmployeeService {

	public ResponseBean saveEmployee(Employee employee);

	public ResponseBean updateEmployee(Employee employee);

	public ResponseBean getAllEmployee( GridDatatableRequestBean gridDatatableRequestBean);

	public ResponseBean getEmployeeById(Long id);

	public ResponseBean getAllEmployees(DataTableRequestBean dataTableRequestBean);




}
