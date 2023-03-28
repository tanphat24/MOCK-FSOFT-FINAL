package com.mockproject.ManagerRestaurant.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockproject.ManagerRestaurant.model.Supplier;
import com.mockproject.ManagerRestaurant.repository.SupplierRepo;

@Service
public class SupplierService {
	@Autowired
	private SupplierRepo repo;

	public void addRepo(Supplier e) {
		repo.save(e);
	}
	
	public List<Supplier> getAllSupplier() {
		return repo.findAll();
	}
	
	public Supplier getSupplierById(int id) {
		Optional<Supplier> w = repo.findById(id);
		if (w.isPresent()) {
			return w.get();
		}
		return null;
	}

	public void deleteSupplier(int id) {
		repo.deleteById(id);
	}
}
