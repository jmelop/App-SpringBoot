package com.nex.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ExampleParamsController {
	
	@GetMapping("/")
	public String index() {
		return "params/index";
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(name="text", required=false, defaultValue="example") String text, Model model) {
		model.addAttribute("result", "The name of the text is: " + text);
		return "params/show";
	}
	
	@GetMapping("/mix-params")
	public String param(@RequestParam String text, @RequestParam Integer number, Model model) {
		model.addAttribute("result", "The text is : '" + text + "' and the number is '" + number + "'");
		return "params/show";
	}
	
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		String text = request.getParameter("text");
		Integer number = null;
		try {
		number = Integer.parseInt(request.getParameter("number"));
		} catch (NumberFormatException e) {
			number = 0;
		}
		model.addAttribute("result", "The text is : '" + text + "' and the number is '" + number + "'");
		return "params/show";
	}

}
