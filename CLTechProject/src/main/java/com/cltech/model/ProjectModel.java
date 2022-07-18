package com.cltech.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
@Builder
@Entity
@Data
@Table(name="project")
public class ProjectModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long projectId;
	@Column
	private String projectName ;
	@Column
	private String projectDescription;
	@Column
	private long fk_employee;

	
	
}
