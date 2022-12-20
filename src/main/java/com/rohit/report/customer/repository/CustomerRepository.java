package com.rohit.report.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rohit.report.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query(value="SELECT * FROM Cutomer_TBL c WHERE plan_name_id= ?",nativeQuery = true)
	public List<Customer> findByPlanName(Integer planNameId);

	@Query(value="SELECT * FROM Cutomer_TBL c WHERE plan_status_id= ?",nativeQuery = true)
	public List<Customer> findByPlanStatus(Integer planStatusId);

	@Query(value="SELECT * FROM Cutomer_TBL c WHERE createdDate >=1 and createdDate <=2 ",nativeQuery = true)
	public List<Customer> finByDate( String startDate, String endDate);
}
