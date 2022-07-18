package com.cltech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
@Table(name = "address")
public class AddressModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long addressId;
	@Column
	private String addressLine;
	@Column
	private String country;
	@Column
	private String state;
	@Column
	private String city;
	@Column
	private String pincode;
	@Column

	private long fk_employeeDetail_id;
	@Column
	private long fk_employee;

}
