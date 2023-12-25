package com.acks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acks.entity.UserAccount;
import com.acks.service.UserAccountService;

@Controller
public class UserAccountController {
	@Autowired
	private UserAccountService service;
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("user", new UserAccount());
		return "index";
		
	}
	@PostMapping("/save-user")
	public String handleSubmitBtn(@ModelAttribute("user") UserAccount user,Model model) {
		
//		System.out.println(user); 
		model.addAttribute("user", new UserAccount());
		String msg = service.saveOrUpdateUserAcc(user);
		model.addAttribute("msg", msg);
		
		return "index";  
		
	}
	@GetMapping("/users")
	public String getUsers(Model model) {
		
		List<UserAccount> allUserAccounts = service.getAllUserAccounts();
		model.addAttribute("users", allUserAccounts);
		return "view-users";
	}
	
	@GetMapping("/edit")
	public String 	editUser(@RequestParam("id") Integer id,Model model) {
		UserAccount userAcc = service.getUserAcc(id);
		 model.addAttribute("user", userAcc);
		
		return "index";
	}
	
	@GetMapping("/delete")
	public String deleteUser( @RequestParam("id") Integer id,Model model) {
	boolean deleteUserAcc = service.deleteUserAcc(id);
	
	model.addAttribute("msg", "User Deleted");			
		return "forward:/users";	
	}
	
	@GetMapping("/update")
	public String statusUpdate ( @RequestParam("id") Integer id,@RequestParam("status") String status ,Model model) {
		service.updateUserAccStatus(id, status);

		
		if(status.equals("Y")) {
			
			model.addAttribute("msg", "user Activated");
		}
		else {
			model.addAttribute("msg", "user De-Activated");
			
		}
		
		
		return "forward:/users";
	}
	
	
	@GetMapping("/activeusers")
	public String activeusers(@RequestParam("status") String status,Model model) {
		
//		service.filter
	List<UserAccount> filterActiveUsers = service.filterActiveUsers(status);
	System.out.println(filterActiveUsers);
	
	model.addAttribute("users", filterActiveUsers);
		
//		System.out.println("active users");
		
		return "view-users";
	}
	
	@GetMapping("/deactiveusers")
	public String deActiveusers(@RequestParam("status") String status,Model model) {
		
//		service.filter
	List<UserAccount> filterDeActiveUsers = service.filterDeActiveUsers(status);
		model.addAttribute("users", filterDeActiveUsers);
//		System.out.println("active users");
		
		return "view-users";
	}

	
	
}
