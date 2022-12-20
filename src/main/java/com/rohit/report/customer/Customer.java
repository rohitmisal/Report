package com.rohit.report.customer;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.rohit.report.plan.PlanName;
import com.rohit.report.plan.PlanStatus;

import lombok.Data;

@Entity
@Table(name="Cutomer_TBL")
@Data
public class Customer {

	@Id
	@GeneratedValue
	private Integer id;

	private String customerName;
	private String customerEmail;
	private Long mobileNo;
	private String gender;
	private Long ssn;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="PLAN_NAME_ID", nullable = false)
	private PlanName planName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="PLAN_STATUS_ID", nullable = false)
	private PlanStatus planStatus;
	
	private Date createdDate;
	//private Date endDate;
	
	
}
