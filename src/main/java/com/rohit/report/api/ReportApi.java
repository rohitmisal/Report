package com.rohit.report.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.report.customer.Customer;
import com.rohit.report.customer.service.CustomerService;
import com.rohit.report.plan.PlanName;
import com.rohit.report.plan.PlanStatus;

@RestController
public class ReportApi {

	@Autowired
	CustomerService custRepo;

	@GetMapping("/customers")
	public List<Customer> fetchAllCustomers() {
		return custRepo.getListOfCustomer();
	}

	@GetMapping("/customer/plannames")
	public List<PlanName> fetchPlanNames() {
		return custRepo.getAllPlanName();
	}

	@GetMapping("/customer/planstatus")
	public List<PlanStatus> fetchPlanStatus() {
		return custRepo.getAllPlanStatus();
	}

	@GetMapping("/customer/planName/{planName}")
	public List<Customer> fetchCustomerByPlanName(@PathVariable("planName") String planName) {
		return custRepo.getListOfCustomerByPlanName(planName);
	}

	@GetMapping("/customer/planStatus/{planStatus}")
	public List<Customer> fetchCustomerByPlanStatus(@PathVariable("planStatus") String planStatus) {
		return custRepo.getListCustomerByPlanStatus(planStatus);
	}

	@GetMapping("/customer/{startDate}/{endDate}")
	public List<Customer> fetchCustomerByDate(@PathVariable("startDate") String startDate,
			@PathVariable("endDate") String endDate) {
		return custRepo.getListCustomerByDate(startDate, endDate);
	}

}
