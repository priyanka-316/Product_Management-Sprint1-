package com.pms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.model.Product;
import com.pms.repository.ProductRepository;
import com.pms.service.ProductService;

import exception.ResourceNotFoundException;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepo;
	
	

	@Override
	public Product SaveProduct(Product product) {
		
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Integer id) throws ResourceNotFoundException
	{ 
		
		Product prod = productRepo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Product", "id", id));
		return prod;
		
	}
	
	

	@Override
	public String removeProduct(Integer id) {
		Product product=productRepo.findById(id).get();
		if(product!=null) 
		{
			productRepo.delete(product);
			return "Product Delete Sucessfully";
		}
		 
		return "Something wrong on server";	
	}

	@Override
	public Product editProduct(Product p, Integer id) {
		
		Product oldProduct=productRepo.findById(id).get();
		oldProduct.setProductName(p.getProductName());
		oldProduct.setDescription(p.getDescription());
		oldProduct.setPrice(p.getPrice());
		oldProduct.setStatus(p.getStatus());
		
		return productRepo.save(oldProduct);
	}

	
	}
	



