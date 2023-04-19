package com.mockproject.ManagerRestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mockproject.ManagerRestaurant.model.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{
	
}
