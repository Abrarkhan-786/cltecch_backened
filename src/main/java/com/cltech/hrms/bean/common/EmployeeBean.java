package com.cltech.hrms.bean.common;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties
public class EmployeeBean implements Serializable {
	private Long id;
	private double totalExperience;
	private String totalSkill;
	private String name;
	private String email;
	private String phone;
	
	
	
	public EmployeeBean() {
		super();
	}



	public EmployeeBean(Long id, double totalExperience, String totalSkill, String name, String email, String phone) {
		super();
		this.id = id;
		this.totalExperience = totalExperience;
		this.totalSkill = totalSkill;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}



	
	
//	@JsonProperty
//	private boolean isFresher;
//	@JsonProperty
//	private boolean isWorking;

	
}
