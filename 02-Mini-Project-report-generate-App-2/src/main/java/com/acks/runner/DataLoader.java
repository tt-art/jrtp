package com.acks.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.acks.entity.CitizenPlan;
import com.acks.repository.CitizenPlanRepo;
@Component
public class DataLoader implements ApplicationRunner {

	
	@Autowired
	private  CitizenPlanRepo repo;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		repo.deleteAll();
		CitizenPlan p1 = new CitizenPlan("JOHN","john@gmail.com",1212312,"Male", 92374,"food","Approved",LocalDate.now(),LocalDate.now().plusMonths(6));
		CitizenPlan p2 = new CitizenPlan("smith","smith@gmail.com",123747,"Male", 234,"Cash","Denied",null,null);
		CitizenPlan p3 = new CitizenPlan("cathy","cathy@gmail.com",234798273,"Fe-Male", 3445,"Food","Approved",LocalDate.now(),LocalDate.now().plusMonths(6));
		CitizenPlan p4 = new CitizenPlan("kanif","kanif@gmail.com",234234,"Male", 54353,"food","denied",null,null);
		CitizenPlan p5 = new CitizenPlan("yogesh","yogesh@gmail.com",8923748,"Male", 2342,"Cash","Approved",LocalDate.now(),LocalDate.now().plusMonths(6));
		CitizenPlan p6 = new CitizenPlan("yash","yash@gmail.com",983940,"Male", 234324,"food","denied",null,null);
		CitizenPlan p7 = new CitizenPlan("vicky","vicky@gmail.com",983940,"Male", 234324,"medical","denied",null,null);
		CitizenPlan p8 = new CitizenPlan("sunny","sunny@gmail.com",983940,"Male", 234324,"medical","Approved",LocalDate.now(),LocalDate.now().plusMonths(6));
		
		List<CitizenPlan> records=Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8);
		repo.saveAll(records);
		
	}

}
