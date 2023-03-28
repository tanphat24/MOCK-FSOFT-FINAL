package com.example.taywebapplication.service;

import com.example.taywebapplication.model.TypeProduct;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ITypeProductService {
    public List<TypeProduct> getAll();
    public TypeProduct getTypeProductById(int id);
    public void addNewTypeProduct(TypeProduct typeProduct );
}
