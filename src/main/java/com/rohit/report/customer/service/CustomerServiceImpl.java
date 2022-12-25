package com.rohit.report.customer.service;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.rohit.report.customer.Customer;
import com.rohit.report.customer.repository.CustomerRepository;
import com.rohit.report.plan.PlanName;
import com.rohit.report.plan.PlanStatus;
import com.rohit.report.plan.repository.PlanNameRepository;
import com.rohit.report.plan.repository.PlanStatusRepository;
import com.rohit.report.search.model.SearchCustWithPlan;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository custRepo;

	@Autowired
	PlanNameRepository pNameRepo;

	@Autowired
	PlanStatusRepository pStatusRepo;

	@Override
	public List<PlanName> getAllPlanName() {
		return pNameRepo.findAll();
	}

	@Override
	public List<PlanStatus> getAllPlanStatus() {
		return pStatusRepo.findAll();
	}

	@Override
	public List<Customer> searchCustomer(SearchCustWithPlan search) {
		Customer customerEntity = new Customer();
		if (search.getPlanName() != null && !search.getPlanName().equals("")) {
			PlanName pn = pNameRepo.findByPlanName(search.getPlanName());
			customerEntity.setPlanName(pn);
		}
		if (search.getPlanStatus() != null && !search.getPlanStatus().equals("")) {
			PlanStatus ps = pStatusRepo.findByPlanStatus(search.getPlanStatus());
			customerEntity.setPlanStatus(ps);
		}
		if (search.getPlanName() != null && !search.getPlanName().equals("")) {
			PlanName pn = pNameRepo.findByPlanName(search.getPlanName());
			PlanStatus ps = pStatusRepo.findByPlanStatus(search.getPlanStatus());
			customerEntity.setPlanName(pn);
			customerEntity.setPlanStatus(ps);
		}
		Example<Customer> userExample = Example.of(customerEntity);
		System.out.println("Example " + userExample);
		List<Customer> records = custRepo.findAll(userExample);

		return records;

	}

	@Override
	public void exportExcel(HttpServletResponse response) throws Exception {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Customer Info");

		XSSFRow headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("Id");
		headerRow.createCell(1).setCellValue("Name");
		headerRow.createCell(2).setCellValue("Gender");
		headerRow.createCell(3).setCellValue("Email");
		headerRow.createCell(4).setCellValue("Mobile No");
		headerRow.createCell(5).setCellValue("Plan Name");
		headerRow.createCell(6).setCellValue("Plan Status");

		List<Customer> listcustomers = custRepo.findAll();
		int dataRowIndex = 1;
		for (Customer c : listcustomers) {
			XSSFRow dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(c.getId());
			dataRow.createCell(1).setCellValue(c.getCustomerName());
			dataRow.createCell(2).setCellValue(c.getGender());
			dataRow.createCell(3).setCellValue(c.getCustomerEmail());
			dataRow.createCell(4).setCellValue(c.getMobileNo());
			dataRow.createCell(5).setCellValue(c.getPlanName().getPlanName());
			dataRow.createCell(6).setCellValue(c.getPlanStatus().getPlanStatus());

			dataRowIndex++;
		}
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}

	@Override
	public void exportPdf(HttpServletResponse response) throws Exception {
		List<Customer> listCustomers = custRepo.findAll();
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();

		Font font = FontFactory.getFont(FontFactory.COURIER_BOLD);
		font.setSize(14);

		Paragraph p = new Paragraph("List Of Customers", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(p);

		PdfPTable table = new PdfPTable(7);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 3.0f, 3.5f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f });
		table.setSpacingBefore(10);
		// set table header data

		PdfPCell cell = new PdfPCell();
		cell.setPadding(5);
		Font f = FontFactory.getFont(FontFactory.COURIER_BOLD);
		f.setSize(13);

		cell.setPhrase(new Phrase("Id", f));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Name", f));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Gender", f));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Email", f));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Mobile No", f));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Plan Name", f));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Plan Status", f));
		table.addCell(cell);

		for (Customer c : listCustomers) {
			table.addCell(String.valueOf(c.getId()));
			table.addCell(c.getCustomerName());
			table.addCell(c.getGender());
			table.addCell(c.getCustomerEmail());
			table.addCell(String.valueOf(c.getMobileNo()));
			table.addCell(c.getPlanName().getPlanName());
			table.addCell(c.getPlanStatus().getPlanStatus());
		}

		document.add(table);
		document.close();

	}

}
