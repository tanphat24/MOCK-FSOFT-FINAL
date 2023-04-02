package com.example.taywebapplication.service;

import com.example.taywebapplication.model.Product;
import com.example.taywebapplication.model.TypeProduct;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductService {
    public List<Product> getAll();
    public Product getProductById(int id);
    public List<Product> getProductByIdTypeProduct(TypeProduct id);
    public void addNewProduct(Product product);
    public void deleteProduct(int id);
    List<Product> search(String productName);

}
