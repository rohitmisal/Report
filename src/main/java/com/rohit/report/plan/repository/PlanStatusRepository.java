package com.rohit.report.plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.rohit.report.plan.PlanStatus;

public interface PlanStatusRepository extends JpaRepository<PlanStatus, Integer> {


}
