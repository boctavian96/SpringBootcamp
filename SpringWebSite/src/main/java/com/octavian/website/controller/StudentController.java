package com.octavian.website.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.octavian.website.model.Student;

@Controller
public class StudentController {

	// Value in folosim sa injectam valori din application.properties.
	// @Value("${property}")

	@Value("${countries}")
	private List<String> countries;

	@Value("${dev.languages}")
	private List<String> languages;

	@Value("${dev.favoriteSystems}")
	private List<String> favoriteSystem;

	@GetMapping("/showStudentForm")
	public String showForm(Model theModel) {

		// Create new Student object.
		Student theStudent = new Student();

		// Add that student object to the model.
		theModel.addAttribute("student", theStudent);

		// Add countries from the properties.
		theModel.addAttribute("countries", countries);

		// Add programming languages.
		theModel.addAttribute("languages", languages);

		theModel.addAttribute("operatingSystems", favoriteSystem);

		return "student-form";
	}

	@PostMapping("/processStudentForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		// Log the data
		System.out.println("The student: " + theStudent);

		return "student-confirmation";
	}
}
