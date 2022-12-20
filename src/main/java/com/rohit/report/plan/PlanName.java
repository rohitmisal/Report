package com.rohit.report.plan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="PLAN_NAME_TBL")
@Data
public class PlanName {

	@Id
	@GeneratedValue
	@Column(name="PLAN_NAME_ID")
	private Integer id;
	
	@Column(name="PLAN_NAME")
	private String planName;
}
