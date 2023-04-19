package com.mockproject.ManagerRestaurant.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mockproject.ManagerRestaurant.model.OrderTable;
import com.mockproject.ManagerRestaurant.model.Tabble;

@Repository
public interface OrderTableRepository extends JpaRepository<OrderTable, Integer>{
	
}
