package com.rohit.report.plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.rohit.report.plan.PlanName;

public interface PlanNameRepository extends JpaRepository<PlanName, Integer> {

}
