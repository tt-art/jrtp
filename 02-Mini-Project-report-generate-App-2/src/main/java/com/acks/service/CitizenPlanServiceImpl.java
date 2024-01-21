package com.acks.service;

import java.util.List;

import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.acks.binding.SearchCriteria;
import com.acks.entity.CitizenPlan;
import com.acks.repository.CitizenPlanRepo;

import io.micrometer.common.util.StringUtils;
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
		
		if(StringUtils.isNotBlank(criteria.getPlanName())) {
			entity.setPlanName(criteria.getPlanName());
		}
		if(StringUtils.isNotBlank(criteria.getPlanStatus())) {
			entity.setPlanStatus(criteria.getPlanStatus());
		}
		
		if(StringUtils.isNotBlank(criteria.getGender())) {
			entity.setGender(criteria.getGender());
		}
		if(criteria.getPlanStartDate()!=null) {
			entity.setPlanStartDate(criteria.getPlanStartDate());
		}
		
		if(criteria.getPlanEndDate()!=null) {
			entity.setPlanEndDate(criteria.getPlanEndDate());
		}
//		Query By Example
		Example<CitizenPlan> of = Example.of(entity);
		
		return repo.findAll(of);
	}

	@Override
	public void generateExcel(HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void generatePdf(HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
