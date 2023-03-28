package com.mockproject.ManagerRestaurant.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockproject.ManagerRestaurant.model.WareHouse;
import com.mockproject.ManagerRestaurant.repository.WareHouseRepo;

@Service
public class WareHouseService {
	@Autowired
	private WareHouseRepo repo;

	public void addWareHouse(WareHouse e) {
		repo.save(e);
	}
	
	public List<WareHouse> getAllWareHouse() {
		return repo.findAll();
	}
	
	public WareHouse getWareHouseById(int id) {
		Optional<WareHouse> w = repo.findById(id);
		if (w.isPresent()) {
			return w.get();
		}
		return null;
	}

	public void deleteWareHouse(int id) {
		repo.deleteById(id);
	}
}
