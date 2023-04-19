package com.mockproject.ManagerRestaurant.service;

import java.util.List;

import com.mockproject.ManagerRestaurant.model.DetailOrder;

public interface DetailOrderService {
	public DetailOrder addDetailOrder(int idTable, int idProduct);
	public DetailOrder upadateDetailOrder(int idTable, int idProduct);
	public List<DetailOrder> getListDetailByOrderTableId(Integer idTable);
	public List<DetailOrder> getListDetail(int idTable);
	public void deleteDetailOrder(int id);
	public DetailOrder getDetailOrderById(int id);
	public void updateQuantityById(int id, int quantity);
	public DetailOrder updateDetailOrder(DetailOrder detailOrder);
}
