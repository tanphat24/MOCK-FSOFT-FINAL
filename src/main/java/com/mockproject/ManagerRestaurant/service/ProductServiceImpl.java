package com.mockproject.ManagerRestaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockproject.ManagerRestaurant.model.Product;
import com.mockproject.ManagerRestaurant.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(int id) {
		return productRepository.findById(id).get();
	}

	@Override
	public List<Product> getListProductOrderById(int id) {
		return productRepository.getListProductOrderById(id);
	}
}
