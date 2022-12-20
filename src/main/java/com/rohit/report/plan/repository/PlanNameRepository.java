package com.rohit.report.plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rohit.report.plan.PlanName;

public interface PlanNameRepository extends JpaRepository<PlanName, Integer> {

	@Query(value = "select plan_name_id from plan_name_tbl where plan_name=?",nativeQuery = true)
	public Integer findByPlanName(String planName);
}
