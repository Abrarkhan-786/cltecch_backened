package com.cltech.hrms.bean;

import com.cltech.hrms.constant.Status;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseBean {
	private Status status;
	private String message;
	private Object response;

}
