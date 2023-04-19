package com.mockproject.ManagerRestaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockproject.ManagerRestaurant.model.Schedule;
import com.mockproject.ManagerRestaurant.repository.ScheduleRepository;

@Service
public class ScheduleServiceImpl implements ScheduleService{
	@Autowired
	private ScheduleRepository scheduleRepository;

	@Override
	public Schedule getScheduleById(int id) {
		return scheduleRepository.findById(id).get();
	}

	@Override
	public Schedule addSchedule(Schedule schedule) {
		return scheduleRepository.save(schedule);
		
	}

	@Override
	public Schedule updateSchedule(Schedule schedule) {	
		return scheduleRepository.save(schedule);
		
	}
}
