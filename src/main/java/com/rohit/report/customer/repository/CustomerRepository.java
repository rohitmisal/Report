package com.rohit.report.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rohit.report.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query(value="SELECT * FROM Cutomer_TBL c WHERE c.plan_name= ?",nativeQuery = true)
	public List<Customer> findByPlanName(String planName);

	@Query(value="SELECT * FROM Cutomer_TBL c WHERE c.planStatus= ?",nativeQuery = true)
	public List<Customer> findByPlanStatus( String planStatus);

	@Query(value="SELECT * FROM Cutomer_TBL c WHERE c.createdDate >=1 and c.createdDate <=2 ",nativeQuery = true)
	public List<Customer> finByDate( String startDate, String endDate);
}
