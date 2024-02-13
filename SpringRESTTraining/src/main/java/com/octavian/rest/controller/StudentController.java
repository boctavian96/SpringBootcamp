package com.octavian.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.octavian.rest.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentController {

	private List<Student> studentsMock = new ArrayList<>();

	@PostConstruct
	public void loadData() {

		studentsMock.add(new Student("Adelas", "Copitas", "adelas@gmail.com"));
		studentsMock.add(new Student("Gabriel", "Grama", "gabi@gmail.com"));
		studentsMock.add(new Student("Daniel", "Jula", "jula.cena@gmail.com"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentsMock;
	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		// Check if student exists.
		if (studentId >= studentsMock.size() || studentId < 0) {
			// Throw Exception
			throw new StudentNotFoundException("Student with id: " + studentId + " not found");
		}
		return studentsMock.get(studentId);
	}
}
