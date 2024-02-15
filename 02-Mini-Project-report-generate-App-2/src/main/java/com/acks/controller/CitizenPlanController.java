package com.acks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.acks.binding.SearchCriteria;
import com.acks.entity.CitizenPlan;
import com.acks.service.CitizenPlanServiceImpl;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CitizenPlanController {
	@Autowired
	private CitizenPlanServiceImpl service;

	@GetMapping("/")
	public String index(Model model) {

		forminit(model);
		model.addAttribute("search", new SearchCriteria());
		return "index";
	}

	@PostMapping("/filter-data")
	public String handleSearchBtn(@ModelAttribute("search") SearchCriteria criteria, Model model) {

		
		List<CitizenPlan> searchCitizens = service.searchCitizens(criteria);
		model.addAttribute("citizens", searchCitizens);
		
		forminit(model);
		System.out.println(criteria);
		return "index";
	}

	private void forminit(Model model) {
		List<String> planNames = service.getPlanNames();
		List<String> planStatus = service.getPlanStatus();
		model.addAttribute("planNames", planNames);
		model.addAttribute("planStatus", planStatus);
	}
	
	@GetMapping("/excel")
	public void downloadExcel(HttpServletResponse response) throws Exception {
		
		response.setContentType("application/octet-stream");
		String headerKey="Content-Disposition";
		String headerValue="attachment;filename=data.xls";
		response.addHeader(headerKey, headerValue);
		service.generateExcel(response);
		
	}
	@GetMapping("/pdf")
	public void downloadPdf(HttpServletResponse response)throws Exception{
		
		response.setContentType("application/pdf");
		String headerKey="Content-Disposition";
		String headerValue="attachment;filename=data.pdf";
		response.addHeader(headerKey, headerValue);
		service.generatePdf(response);
	}
	
	
	

}
