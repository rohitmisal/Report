package com.rohit.report.plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rohit.report.plan.PlanStatus;

public interface PlanStatusRepository extends JpaRepository<PlanStatus, Integer> {

	@Query(value="select * from plan_status_tbl where plan_status=?",nativeQuery = true)
	public PlanStatus findByPlanStatus(String planName);
	
	
}
