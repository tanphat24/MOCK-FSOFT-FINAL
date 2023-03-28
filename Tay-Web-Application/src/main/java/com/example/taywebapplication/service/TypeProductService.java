package com.example.taywebapplication.service;

import com.example.taywebapplication.model.TypeProduct;
import com.example.taywebapplication.repository.ITypeProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("typeProductService")
public class TypeProductService implements ITypeProductService{
    @Autowired
    private ITypeProductRepository typeProductRepository;
    @Override
    public List<TypeProduct> getAll() {
        return typeProductRepository.findAll();
    }

    @Override
    public TypeProduct getTypeProductById(int id) {
        return typeProductRepository.findById(id).orElse(null);
    }

    @Override
    public void addNewTypeProduct(TypeProduct typeProduct) {
        typeProductRepository.save(typeProduct);
    }
}
