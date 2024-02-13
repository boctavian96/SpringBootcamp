package com.octavian.jpa.dao;

import java.util.List;

import com.octavian.jpa.entity.Student;

public interface StudentDAO {
	void save(Student student);

	Student find(int id);

	List<Student> findAll();

	List<Student> findByLastName(String lastName);

	void update(Student student);
	
	void delete(int id);
}
