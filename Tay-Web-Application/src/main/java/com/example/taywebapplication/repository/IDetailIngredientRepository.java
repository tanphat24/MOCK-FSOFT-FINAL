package com.example.taywebapplication.repository;

import com.example.taywebapplication.model.DetailIngredient;
import com.example.taywebapplication.service.DetailIngredientService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetailIngredientRepository extends JpaRepository<DetailIngredient,Integer> {
}
