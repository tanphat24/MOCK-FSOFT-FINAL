package com.mockproject.ManagerRestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mockproject.ManagerRestaurant.model.Supplier;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier, Integer> {

}
