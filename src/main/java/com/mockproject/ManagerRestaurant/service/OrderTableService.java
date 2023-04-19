package com.mockproject.ManagerRestaurant.service;

import org.springframework.stereotype.Service;

import com.mockproject.ManagerRestaurant.model.OrderTable;

@Service
public interface OrderTableService{
	public void orderTableOffline(int idTable);
	public boolean orderTableOnline(int idCustomer, String name, String email, int quantity, String phone, String date, String time, String note);
	public OrderTable getOrderTableById(int id);
}
