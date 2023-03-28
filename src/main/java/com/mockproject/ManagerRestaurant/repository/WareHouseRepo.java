package com.mockproject.ManagerRestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.mockproject.ManagerRestaurant.model.WareHouse;

@Repository
public interface WareHouseRepo extends JpaRepository<WareHouse, Integer> {

}
