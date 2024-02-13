package com.octavian.jpa.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.octavian.jpa.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO {

	private EntityManager entityManager;

	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	@Override
	public void save(Student student) {
		entityManager.persist(student);
	}

	@Override
	public Student find(int id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		// Create Query.
		TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);

		// Return Query Results.
		return query.getResultList();
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName = :last_name ",
				Student.class);

		// Setting types.
		query.setParameter("last_name", lastName);

		return query.getResultList();
	}

	@Transactional
	@Override
	public void update(Student student) {
		entityManager.merge(student);
	}

	@Transactional
	@Override
	public void delete(int id) {
		Student s = entityManager.find(Student.class, id);
		entityManager.remove(s);
	}

}
