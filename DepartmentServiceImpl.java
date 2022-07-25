package com.cltech.hrms.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cltech.hrms.bean.Department;
import com.cltech.hrms.bean.Education;
import com.cltech.hrms.bean.ResponseBean;
import com.cltech.hrms.constant.Status;
import com.cltech.hrms.repository.DepartmentRepository;
import com.cltech.hrms.repository.EducationRepository;
import com.cltech.hrms.service.PropertyService;

@Service
public class DepartmentServiceImpl {
//	@Autowired
//	@Qualifier("propertyServiceImpl")
//	protected PropertyService propertyService;

	private static Logger LOGGER = LogManager.getLogger(EducationServiceImpl.class);

	@Autowired
	private DepartmentRepository departmentRepo;

	public ResponseBean addDepartment(Department dep) {

		try {
//			Department d = departmentRepo.save(dep);
//			System.out.println(d+ "Department");

			if (dep == null) {
				return ResponseBean.builder().status(Status.FAIL).message("Kindly Provide the Department Details")
						.build();
			} else {
				Department departmentBean = departmentRepo.save(dep);
				return ResponseBean.builder().status(Status.SUCCESS).message("Record has been Added Successfully")
						.response(departmentBean).build();
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseBean.builder().status(Status.FAIL).message("Something Went Wrong").build();
		}
	}

	public ResponseBean getAllDepartmentDetails() {
		List<Department> list = departmentRepo.findAll();

		try {
			if (list.size() <= 0) {
				return ResponseBean.builder().status(Status.FAIL).message("Data is Null").build();
			}

			else {
//			List<Department> list2 = departmentRepo.findAll();
				return ResponseBean.builder().status(Status.SUCCESS).message("This is the List of DepartmentDetails")
						.response(list).build();
			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseBean.builder().status(Status.FAIL).message("Something Went Wrong").build();
		}
	}

	public ResponseBean getDepartmentDetailsById(long id) {

		Department dep = departmentRepo.findById(id).get();

		try {
			if (dep == null) {
				return ResponseBean.builder().status(Status.FAIL).message("No Data Found With The Given Id").build();
			} else {
				return ResponseBean.builder().status(Status.SUCCESS)
						.message("This is the data which is found from Databases").response(dep).build();
			}

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return ResponseBean.builder().status(Status.FAIL).message("Something Went Wrong").build();
		}
	}

	public ResponseBean updateDepartmentDetails(Department dep) {
		try {
			if (dep == null) {
				return ResponseBean.builder().status(Status.FAIL).message("null").build();
			}
			if (dep.getId() > 0) {
				Optional<Department> findById = departmentRepo.findById(dep.getId());
				System.out.println("findById" + findById);
				if (findById != null) {
					System.out.println("check" +findById != null);
					Department departmentBean = departmentRepo.save(dep);
					System.out.println("departmentBean" + departmentBean);
					return ResponseBean.builder().status(Status.SUCCESS).message("Record updated Successfully")
							.response(departmentBean).build();
				}

			} else {
				return ResponseBean.builder().status(Status.FAIL).message("please provide id").build();
			}
			return ResponseBean.builder().status(Status.FAIL).message("Record Not Found").build();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseBean.builder().status(Status.FAIL).message("Something Went Wrong").build();
		}
	}

	public ResponseBean deleteById(long id) {

		try {
			departmentRepo.deleteById(id);
			return ResponseBean.builder().status(Status.SUCCESS).message("Deleted Successfully").build();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseBean.builder().status(Status.FAIL).message("Something Went Wrong").build();
		}
	}

}
