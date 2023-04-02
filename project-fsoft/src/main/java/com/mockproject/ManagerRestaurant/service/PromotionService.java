package com.mockproject.ManagerRestaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockproject.ManagerRestaurant.model.Promotion;
import com.mockproject.ManagerRestaurant.repository.PromotionRepository;


public interface PromotionService {
	List<Promotion> getAll();
	Promotion save(Promotion promotion);
	Promotion getPromotionById(Integer id);
	void deletePromotion(int id);
	Promotion getPromotionId(Double discount);
}
