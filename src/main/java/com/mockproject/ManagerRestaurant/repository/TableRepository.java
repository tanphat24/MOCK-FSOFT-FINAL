package com.mockproject.ManagerRestaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mockproject.ManagerRestaurant.model.Tabble;

@Repository
public interface TableRepository extends JpaRepository<Tabble, Integer>{
	@Query(value = "select t.* from tabble t where t.TABLE_STATUS='Trống'", nativeQuery = true)
	List<Tabble> getListTableEmpty();
}