package com.octavian.jpa;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.octavian.jpa.dao.StudentDAO;
import com.octavian.jpa.entity.Student;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			updateStudent(studentDAO, 1);
			readStudentsByLastName(studentDAO, "Gooby");
			readStudentsByLastName(studentDAO, "Grama");
			readStudentsByLastName(studentDAO, "Berbecelul");
		};
	}

	private void updateStudent(StudentDAO studentDAO, int id) {
		// Read the student.
		Student student = studentDAO.find(id);

		// Change email.
		student.setEmail("adelian@gmail.com");

		studentDAO.update(student);
	}

	private void readAllStudents(StudentDAO studentDAO) {
		System.out.println("Printing all the students");
		List<Student> students = studentDAO.findAll();
		students.forEach(System.out::println);
	}

	private void readStudentsByLastName(StudentDAO studentDAO, String lastName) {
		System.out.println("Searching for the last name: " + lastName);
		var students = studentDAO.findByLastName(lastName);

		if (students.isEmpty()) {
			System.err.println("No students found");
		} else {
			students.forEach(System.out::println);
		}

	}

	private void saveStudent(StudentDAO studentDAO) {
		System.out.println("Creating new Student");
		Student tempStudent = new Student("Adelian", "Berbecelul", "patrucopite@google.com");

		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		System.out.println("Fetching the student: " + tempStudent.getId());
	}

	private void readStudent(int id, StudentDAO studentDAO) {
		var s = Optional.ofNullable(studentDAO.find(id));
		if (s.isPresent()) {
			System.out.println(s.get().toString());
		} else {
			System.err.println("Student not found!");
		}
	}

}
