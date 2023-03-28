package com.mockproject.ManagerRestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mockproject.ManagerRestaurant.model.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

}
