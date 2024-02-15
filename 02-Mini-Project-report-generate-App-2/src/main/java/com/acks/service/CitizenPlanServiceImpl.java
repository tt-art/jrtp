package com.acks.service;

import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.acks.binding.SearchCriteria;
import com.acks.entity.CitizenPlan;
import com.acks.repository.CitizenPlanRepo;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CitizenPlanServiceImpl implements CitizenPlanService {

	@Autowired
	private CitizenPlanRepo repo;

	@Override
	public List<String> getPlanNames() {
		// TODO Auto-generated method stub
		List<String> planNames = repo.getPlanNames();
		return planNames;
	}

	@Override
	public List<String> getPlanStatus() {
		// TODO Auto-generated method stub
		return repo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> searchCitizens(SearchCriteria criteria) {
		// TODO Auto-generated method stub

		CitizenPlan entity = new CitizenPlan();

		if (StringUtils.isNotBlank(criteria.getPlanName())) {
			entity.setPlanName(criteria.getPlanName());
		}
		if (StringUtils.isNotBlank(criteria.getPlanStatus())) {
			entity.setPlanStatus(criteria.getPlanStatus());
		}

		if (StringUtils.isNotBlank(criteria.getGender())) {
			entity.setGender(criteria.getGender());
		}
		if (criteria.getPlanStartDate() != null) {
			entity.setPlanStartDate(criteria.getPlanStartDate());
		}

		if (criteria.getPlanEndDate() != null) {
			entity.setPlanEndDate(criteria.getPlanEndDate());
		}
//		Query By Example
		Example<CitizenPlan> of = Example.of(entity);

		return repo.findAll(of);
	}

	@Override
	public void generateExcel(HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		List<CitizenPlan> records = repo.findAll();
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Data");
		HSSFRow headerRow = sheet.createRow(0);

//		set data for header row cells
		headerRow.createCell(0).setCellValue("Name");
		headerRow.createCell(1).setCellValue("Email");
		headerRow.createCell(2).setCellValue("Gender");
		headerRow.createCell(3).setCellValue("SSN");
		headerRow.createCell(4).setCellValue("Plan Name");
		headerRow.createCell(5).setCellValue("Plan Status");

		int rowIndex = 1;

		for (CitizenPlan record : records) {
			HSSFRow dataRow = sheet.createRow(rowIndex);
			dataRow.createCell(0).setCellValue(record.getName());
			dataRow.createCell(1).setCellValue(record.getEmail());
			dataRow.createCell(2).setCellValue(record.getGender());
			dataRow.createCell(3).setCellValue(record.getSsn());
			dataRow.createCell(4).setCellValue(record.getPlanName());
			dataRow.createCell(5).setCellValue(record.getPlanStatus());
			rowIndex++;
		}
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();

	}
	
	

	@Override
	public void generatePdf(HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		List<CitizenPlan> records =repo.findAll();
		
		Document PdfDoc=new Document(PageSize.A4);
		ServletOutputStream outputStream = response.getOutputStream();
		PdfWriter.getInstance(PdfDoc, outputStream);
		PdfDoc.open();
		Paragraph p=new Paragraph("Cititzen Plans Info");
		PdfDoc.add(p);
		
		PdfDoc.close();
		outputStream.close();

	}

}
