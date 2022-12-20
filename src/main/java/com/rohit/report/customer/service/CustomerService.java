package com.rohit.report.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rohit.report.customer.Customer;
import com.rohit.report.plan.PlanName;
import com.rohit.report.plan.PlanStatus;

public interface CustomerService {

	public List<PlanName> getAllPlanName();

	public List<PlanStatus> getAllPlanStatus();

	public List<Customer> getListOfCustomer();

	public List<Customer> getListOfCustomerByPlanName(String planName);

	public List<Customer> getListCustomerByPlanStatus(String planStatus);
	
	public List<Customer> getListCustomerByDate(String startDate,String endDate);

}
