package com.rohit.report.customer.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.rohit.report.customer.Customer;
import com.rohit.report.plan.PlanName;
import com.rohit.report.plan.PlanStatus;
import com.rohit.report.search.model.SearchCustWithPlan;

public interface CustomerService {

	public List<PlanName> getAllPlanName();

	public List<PlanStatus> getAllPlanStatus();

	public List<Customer> searchCustomer(SearchCustWithPlan search);

	public void exportExcel(HttpServletResponse response) throws Exception;

	public void exportPdf(HttpServletResponse response) throws Exception;

	/*
	 * public List<Customer> getListOfCustomerByPlanName(String planName);
	 * 
	 * public List<Customer> getListCustomerByPlanStatus(String planStatus);
	 * 
	 * public List<Customer> getListCustomerByDate(String startDate, String
	 * endDate);
	 */

}
