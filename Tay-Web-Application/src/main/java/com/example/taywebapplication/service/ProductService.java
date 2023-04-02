package com.example.taywebapplication.service;

import com.example.taywebapplication.model.Product;
import com.example.taywebapplication.model.TypeProduct;
import com.example.taywebapplication.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("productService")
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getProductByIdTypeProduct(TypeProduct id) {
        return productRepository.findAllByTypeProduct(id);
    }

    @Override
    public void addNewProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> search(String productName) {
        return productRepository.findAllByNameProduct(productName);
    }
}
