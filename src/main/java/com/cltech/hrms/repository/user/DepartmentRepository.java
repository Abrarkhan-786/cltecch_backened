package com.cltech.hrms.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cltech.hrms.bean.user.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}