package com.nex.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nex.springboot.web.app.models.User;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@GetMapping({"/home", "/", "/index"})
	public String index(Model model) {
		model.addAttribute("title", "Hello Spring framework");
		return "index";
	}
	
	@RequestMapping("/profile")
	public String profile(Model model) {
		User user = new User();
		user.setName("Linus");
		user.setLastname("Torvalds");
		user.setEmail("example@gmail.com");

		model.addAttribute("user", user);
		model.addAttribute("title", "User profile: ".concat(user.getName()));
		return "profile";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("title", "User list");

		return "list";
	}
	
	@ModelAttribute("users")
	public List<User> addUsers() {
		List<User> users = new ArrayList<>();
		users.add(new User("Linus", "Torvalds", "example@gmail.com"));
		users.add(new User("John", "Doe", "john@gmail.com"));
		users.add(new User("Jane", "Doe", "jane@gmail.com"));
		
		return users;
	}

}
