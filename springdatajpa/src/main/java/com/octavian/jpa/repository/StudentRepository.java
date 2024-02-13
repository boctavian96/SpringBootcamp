package com.octavian.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.octavian.jpa.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
