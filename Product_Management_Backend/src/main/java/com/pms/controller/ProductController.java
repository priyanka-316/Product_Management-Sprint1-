package com.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.*;

import com.pms.model.Product;
import com.pms.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {

@Autowired
private ProductService productService ;

@Secured("ROLE_ADMIN")
@PostMapping("/saveProduct")
public ResponseEntity<?> saveProduct(@RequestBody Product product)
	{
		return new ResponseEntity<>(productService.SaveProduct(product),HttpStatus.CREATED);
	}

@GetMapping("/products")
public ResponseEntity<?> getAllProduct()
{	
	return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.OK);
}

@GetMapping("/{id}")
public Product getProductById(@PathVariable("id") int id)  {
	return 	productService.getProductById(id);
}

@Secured("ROLE_ADMIN")
@DeleteMapping("/removeProduct/{id}")
public ResponseEntity<?> deleteProduct(@PathVariable Integer id)
{
	return new ResponseEntity<>(productService.removeProduct(id),HttpStatus.OK);
}

@Secured("ROLE_ADMIN")
@PutMapping("/editProduct/{id}")
public ResponseEntity<?> editProduct(@RequestBody Product product,@PathVariable Integer id)
{
	return new ResponseEntity<>(productService.editProduct(product,id),HttpStatus.CREATED);
}


}





  
