package com.mockproject.ManagerRestaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockproject.ManagerRestaurant.model.Promotion;
import com.mockproject.ManagerRestaurant.repository.PromotionRepository;

@Service
public class PromotionService {
	@Autowired
	private PromotionRepository promotionRepository;
	
	public List<Promotion> getAll() {
		return promotionRepository.findAll();
	}
	public Promotion save(Promotion promotion) {
		return promotionRepository.save(promotion);
	}
	public Promotion getPromotionById(Integer id) {
		return promotionRepository.findById(id).orElse(null);
	}
	public void deletePromotion(int id) {
		promotionRepository.deleteById(id);;
	}
}
