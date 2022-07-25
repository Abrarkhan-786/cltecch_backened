package com.cltech.hrms.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cltech.hrms.bean.Employee;
import com.cltech.hrms.bean.common.EmployeeBean;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Query(
			  "SELECT "
			+ "new com.cltech.hrms.bean.common.EmployeeBean("
			+ "e.id,e.totalExperience,e.totalSkill, "
			+ "concat(d.firstName, ' ',d.lastName) as name, "
			+ "d.email  as email, d.phone as phone"
			+ ") "
			+ "FROM  #{#entityName} e "
			+ "Left join "
			+ "e.employeeDetail d "
			+ "WHERE "
		    + "CONCAT(e.id, '') LIKE %:query% "
    		+ "OR "
    		+ "d.firstName LIKE CONCAT('%',:query,'%') "
			+ "OR "
			+ "d.email LIKE CONCAT('%',:query,'%') "
			+ "OR "
			+ "d.phone LIKE CONCAT('%',:query,'%') "
			+"OR "
			+"e.totalSkill LIKE CONCAT('%',:query,'%') "
			+ "OR "
			+"CONCAT(e.totalExperience, '') LIKE %:query% "
     		//+"GROUP BY :column"
			
			)
	   public List<EmployeeBean> getAllEmployees(@Param("query") String query,  Pageable page);

}
