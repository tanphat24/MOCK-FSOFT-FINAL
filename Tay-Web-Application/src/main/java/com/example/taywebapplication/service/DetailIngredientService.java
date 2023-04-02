package com.example.taywebapplication.service;

import com.example.taywebapplication.model.DetailIngredient;
import com.example.taywebapplication.repository.IDetailIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailIngredientService implements IDetailIngredientService{
    @Autowired
    private IDetailIngredientRepository detailIngredientRepository;
    @Override
    public List<DetailIngredient> getAllDetailIngredient() {
        return detailIngredientRepository.findAll();
    }
}
