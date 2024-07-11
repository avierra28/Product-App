package com.tony.code.back_end.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tony.code.back_end.dao.ProductRepository;
import com.tony.code.back_end.entities.Products;

@RestController
public class MainController {

	@Autowired
	private ProductRepository productRepository;
	
	private ArrayList<Products> myArrayList;

	@GetMapping("/products")
	public ArrayList<Products> getAllProducts() {

		myArrayList = (ArrayList<Products>) productRepository.findAll();

		return myArrayList;
	}
	
	@GetMapping("/products/{id}")
	public Products getProduct(@PathVariable(name = "id") Long id) {
		
		return productRepository.findById(id).get();
	}
	
	@PostMapping("/products/createProduct")
	public void createProduct(@RequestBody Products products) {
		
		productRepository.save(products);
	}
	
	@DeleteMapping("/products/deleteProduct/{id}")
	public void deleteProduct(@PathVariable(name = "id") Long id) {
		productRepository.deleteById(id);
	}
	
	/* @PutMapping("/products/updateProduct/{id}") */
	@RequestMapping(method = RequestMethod.PUT, value = "/products/updateProduct/{id}", consumes = "application/json")
	public void updateProduct(@RequestBody Products products, @PathVariable(name = "id") Long id) {
		
		Products myProducts = new Products();
		
		System.out.println(products);
		
		myProducts = productRepository.findById(id).map(product -> {
			product.setName(products.getName());
			product.setDescription(products.getDescription());
			product.setPrice(products.getPrice());
			productRepository.save(products);
			return product;
		}).orElseThrow(() -> new RuntimeException("Product not found with id " + id));
	}
}







