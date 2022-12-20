package com.rohit.report.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohit.report.customer.Customer;
import com.rohit.report.customer.repository.CustomerRepository;
import com.rohit.report.plan.PlanName;
import com.rohit.report.plan.PlanStatus;
import com.rohit.report.plan.repository.PlanNameRepository;
import com.rohit.report.plan.repository.PlanStatusRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository custRepo;

	@Autowired
	PlanNameRepository pNameRepo;

	@Autowired
	PlanStatusRepository pStatusRepo;

	@Override
	public List<Customer> getListOfCustomer() {
		return custRepo.findAll();
	}

	@Override
	public List<PlanName> getAllPlanName() {

		return pNameRepo.findAll();
	}

	@Override
	public List<PlanStatus> getAllPlanStatus() {
		
		return pStatusRepo.findAll();
	}

	@Override
	public List<Customer> getListOfCustomerByPlanName(String planName) {
		
		return custRepo.findByPlanName(planName);
	}

	@Override
	public List<Customer> getListCustomerByPlanStatus(String planStatus) {

		return custRepo.findByPlanStatus(planStatus);
	}

	@Override
	public List<Customer> getListCustomerByDate(String startDate, String endDate) {
		
		return custRepo.finByDate(startDate,endDate);
	}

}
