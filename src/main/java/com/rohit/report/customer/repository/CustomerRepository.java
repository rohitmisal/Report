package com.rohit.report.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rohit.report.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("SELECT c FROM Cutomer_TBL c WHERE c.planName= ?1")
	public List<Customer> findByPlanName(String planName);

	@Query("SELECT c FROM Cutomer_TBL c WHERE c.planStatus= ?1")
	public List<Customer> findByPlanStatus( String planStatus);

	@Query("SELECT c FROM Cutomer_TBL c WHERE c.createdDate >=  ?1 and c.createdDate <=  ?2 ")
	public List<Customer> finByDate( String startDate, String endDate);
}
