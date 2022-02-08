package com.nex.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class PathVariableExampleController {
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("title", "Send parameters from path (@PathVariable)");

		return "variables/index";
	}
	
	@GetMapping("/string/{text}")
	public String variables(@PathVariable String text, Model model) {
		model.addAttribute("title", "Get parameters from path (@PathVariable)");
		model.addAttribute("result", "The text in the path is " + text);
		return "variables/show";
	}
	
	@GetMapping("/string/{text}/{number}")
	public String variables(@PathVariable String text, @PathVariable Integer number, Model model) {
		model.addAttribute("title", "Get parameters from path (@PathVariable)");
		model.addAttribute("result", "The text in the path is " + text
				+ " and the number in the path is: " + number);
		return "variables/show";
	}

}
