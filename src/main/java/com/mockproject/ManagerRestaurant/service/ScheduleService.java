package com.mockproject.ManagerRestaurant.service;

import com.mockproject.ManagerRestaurant.model.Schedule;

public interface ScheduleService{
	public Schedule getScheduleById(int id);
	public Schedule addSchedule(Schedule schedule);
	public Schedule updateSchedule(Schedule schedule);
	
}
