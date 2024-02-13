package com.octavian.jpa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.octavian.jpa.entities.Student;
import com.octavian.jpa.repository.StudentRepository;

@SpringBootTest
class SpringdatajpaApplicationTests {

	@Autowired
	private StudentRepository repository;

	@Test
	void testSaveStudent() {
		Student s = new Student();
		s.setId(1);
		s.setName("Octavian");
		s.setScore(69);

		repository.save(s);

		Student foundStudent = repository.findById(1l).get();

		Assertions.assertNotNull(foundStudent);
	}

}
