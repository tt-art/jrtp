package com.acks.service;

import java.util.List;

import com.acks.binding.SearchCriteria;
import com.acks.entity.CitizenPlan;

import jakarta.servlet.http.HttpServletResponse;

public interface CitizenPlanService {
public List<String> getPlanNames();
public  List<String> getPlanStatus();
public List<CitizenPlan> searchCitizens(SearchCriteria criteria);
public void generateExcel(HttpServletResponse response);
public void generatePdf(HttpServletResponse response);



}
