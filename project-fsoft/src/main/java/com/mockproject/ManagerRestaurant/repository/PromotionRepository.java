package com.mockproject.ManagerRestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mockproject.ManagerRestaurant.model.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

	@Query(value = "Select p.* from promotion p where p.promotion_discount= :discount", nativeQuery = true)
	Promotion getPromotionId(Double discount);
}
