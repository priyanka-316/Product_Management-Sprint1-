package com.pms.service;

import java.util.List;

import com.pms.model.Product;

public interface ProductService {
	
	public Product SaveProduct(Product product);
	
	public List<Product> getAllProduct();
	
	public Product getProductById(Integer id);
	
	public String removeProduct(Integer id);
	
	public Product editProduct(Product product,Integer id);
	
	
	
		
	
}
