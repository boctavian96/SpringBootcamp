package com.octavian.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.octavian.service.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
