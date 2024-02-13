package com.octavian.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class DemoController {
	// Create mapping for '/hello'.

	@GetMapping("/hello")
	public String sayHello(Model model) {
		/*
		 * model.addAttribute("name", "Octavian"); model.addAttribute("date", new
		 * Date());
		 */

		// Return-ul trebuie sa match-uiasca cu numele fisierului html.
		return "helloworld";
	}

	@GetMapping("/showForm")
	public String showForm(Model model) {
		return "helloworld-form";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	// Controller to add data to the model.
	@GetMapping("/processFormVersionTwo")
	public String addDataPloz(HttpServletRequest request, Model model) {
		// Read request parameter from the HTML form.
		String theName = request.getParameter("studentName");

		// Convert data to all caps.
		theName = theName.toUpperCase();

		// Create the message.
		String result = "Yo! " + theName;

		// Add message to the model.
		model.addAttribute("message", result);

		return "helloworld";
	}

	@GetMapping("/processFormVersionThree")
	public String addDataParamPloz(@RequestParam("studentName") String studentName, Model model) {

		// Convert data to all caps.
		String theName = studentName.toUpperCase();

		// Create the message.
		String result = "Biatch, this is V3: " + theName;

		// Add message to the model.
		model.addAttribute("message", result);

		return "helloworld";
	}

}
