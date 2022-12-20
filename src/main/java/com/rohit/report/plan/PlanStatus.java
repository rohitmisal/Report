package com.rohit.report.plan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="PLAN_STATUS_TBL")
@Data
public class PlanStatus {

	@Id
	@GeneratedValue
	@Column(name="PLAN_STATUS_ID")
	private Integer id;

	@Column(name="PLAN_STATUS")
	private String planStatus;
	
	
}
