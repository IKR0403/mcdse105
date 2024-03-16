package com.example.mcdse105.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.mcdse105.entity.User;
import com.example.mcdse105.service.UserService;

@Controller
public class CommonController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String getHomepage() {
		return "index";
		}

	@GetMapping("/about")
	public String getAboutPage() {
		return "about";
		}
	
	@GetMapping("/contact")
	public String getContactpage() {
		return "contact";
		}
	
	@GetMapping("/register")
	public String getRegistrationpage() {
		return "register";
	}
	
	@PostMapping("/register")
public String registerNewUser(Model model, @ModelAttribute("user") User user, @RequestParam String cpassword,  @RequestParam String role) {
		
		if(!userService.verifyEmail(user.getEmail())) {
			
			if(user.getPassword().matches(cpassword)) {
				userService.registerNewUser(user, role);
				return "index";
				
			} else {
				model.addAttribute("errmsg", "Password not match!");
				return "register";
			}
			
		} else {
			model.addAttribute("errmsg", "User/email already exists!");
			return "register";
		}
	}
	
	@GetMapping("/login")
	public String getLoginpage() {
		return "login";
	}
	
}



