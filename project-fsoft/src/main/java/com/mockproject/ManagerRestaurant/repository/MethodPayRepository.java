package com.mockproject.ManagerRestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mockproject.ManagerRestaurant.model.Method_payment;

public interface MethodPayRepository extends JpaRepository<Method_payment, Integer> {

}
