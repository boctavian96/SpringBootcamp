package com.octavian.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.octavian.rest.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
