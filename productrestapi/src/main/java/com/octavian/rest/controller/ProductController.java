package com.octavian.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.octavian.rest.entities.Product;
import com.octavian.rest.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@GetMapping(value = "/products/")
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@GetMapping(value = "/products/{id}")
	public Product getProduct(@PathVariable("id") int id) {
		return productRepository.findById(id).get();
	}

	@PostMapping(value = "/products/")
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}

	@PutMapping(value = "/products/")
	public Product updateProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}

	@DeleteMapping(value = "/products/")
	public void deleteProduct(@PathVariable("id") int id) {
		productRepository.deleteById(id);
	}

}
