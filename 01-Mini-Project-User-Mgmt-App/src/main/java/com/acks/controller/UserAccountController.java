package com.acks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acks.entities.UserAccount;

@Controller
public class UserAccountController {
	
	@GetMapping("/")
public String index(Model model) {
		
		model.addAttribute("user", new UserAccount());
		System.out.println("hello");
	return "index";  
	}
	@PostMapping("/saveuser")
	public String handleSubmitBtn(@ModelAttribute("user") UserAccount user,Model model) {
//		System.out.println(user);
		System.out.println(user);
		
		return "index";
		
	}
}
