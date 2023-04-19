package com.mockproject.ManagerRestaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mockproject.ManagerRestaurant.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	@Query(value = "select p.* from product p where p.PRODUCT_ID = :id", nativeQuery = true)
	List<Product> getListProductOrderById(int id);
}
