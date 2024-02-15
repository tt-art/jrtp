package com.acks;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.acks.entity.CitizenPlan;
import com.acks.service.CitizenPlanServiceImpl;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	 SpringApplication.run(Application.class, args);
		
	}

}
