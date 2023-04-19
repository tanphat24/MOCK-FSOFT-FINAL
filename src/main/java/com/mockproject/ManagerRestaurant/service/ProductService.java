package com.mockproject.ManagerRestaurant.service;

import java.util.List;

import com.mockproject.ManagerRestaurant.model.Product;

public interface ProductService {
	public List<Product> getAllProduct();
	public Product getProductById(int id);
	public List<Product> getListProductOrderById(int id);
}
