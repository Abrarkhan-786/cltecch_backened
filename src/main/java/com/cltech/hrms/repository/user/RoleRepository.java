package com.cltech.hrms.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cltech.hrms.bean.user.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
