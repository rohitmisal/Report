package com.rohit.report.api;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.report.customer.Customer;
import com.rohit.report.customer.service.CustomerService;
import com.rohit.report.plan.PlanName;
import com.rohit.report.plan.PlanStatus;
import com.rohit.report.search.model.SearchCustWithPlan;

@RestController
public class ReportApi {

	@Autowired
	CustomerService custRepo;

	@GetMapping("/customer/plannames")
	public ResponseEntity<List<PlanName>> fetchPlanNames() {
		List<PlanName> planName = custRepo.getAllPlanName();
		return new ResponseEntity<>(planName, HttpStatus.OK);
	}

	@GetMapping("/customer/planstatus")
	public ResponseEntity<List<PlanStatus>> fetchPlanStatus() {
		List<PlanStatus> planStatus = custRepo.getAllPlanStatus();
		return new ResponseEntity<>(planStatus, HttpStatus.OK);
	}

	@PostMapping("/customer/search")
	public ResponseEntity<List<Customer>> searchCustomers(@RequestBody SearchCustWithPlan search) {
		List<Customer> listCustomers = custRepo.searchCustomer(search);
		return new ResponseEntity<>(listCustomers, HttpStatus.OK);

	}

	@GetMapping("/customer/excel")
	public void generateExcel(HttpServletResponse response) throws Exception {

		response.setContentType("application/octet-stream");
		String key = "Content-Disposition";
		String value = "attachment;filename=customer.xlsx";

		response.setHeader(key, value);
		custRepo.exportExcel(response);
		response.flushBuffer();

	}

	@GetMapping("/customer/pdf")
	public void generatePdf(HttpServletResponse response) throws Exception {

		response.setContentType("application/pdf");
		String key = "Content-Disposition";
		String value = "attachment;filename=customer.pdf";

		response.setHeader(key, value);
		custRepo.exportPdf(response);
		response.flushBuffer();

	}

}
