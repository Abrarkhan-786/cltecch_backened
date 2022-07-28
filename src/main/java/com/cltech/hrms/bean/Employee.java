package com.cltech.hrms.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column
	String carrierObjective; // allowed character 256 or 512

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="employeeDetailId")
	EmployeeDetail employeeDetail;

	@OneToMany(cascade = CascadeType.ALL )
	@JoinColumn(name="employeeId")
	List<Skill> skills;

	@OneToMany(cascade = CascadeType.ALL )
	@JoinColumn(name="employeeId")
	List<Experience> experiences;

	@OneToMany(cascade = CascadeType.ALL )
	@JoinColumn(name="employeeId")
	List<Education> educations;

	
	@OneToMany(cascade = CascadeType.ALL )
	@JoinColumn(name="employeeId")
	List<Project> projects;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="employeeId")
	List<Language> languages;

	@Column
	@JsonProperty
	boolean isWorking;
	
	@Column
	@JsonProperty
	boolean isFresher;
	
	double currentCTC;
	double expectedCTC;
	String preferedLocation; // optional
	String certifications;
	String hobbies;
	String totalSkill;
	double totalExperience;

	@OneToOne(cascade = CascadeType.ALL )
	@JoinColumn(name="socialMediaLinkId")
	SocialMedialLinks socialMediaLinks;
	
	@OneToMany(cascade = CascadeType.ALL )
	@JoinColumn(name="employeeId")
	List<Post> posts;

}
