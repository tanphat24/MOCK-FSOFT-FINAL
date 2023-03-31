package com.mockproject.ManagerRestaurant.service;

import java.util.List;

import com.mockproject.ManagerRestaurant.model.Bill;
import com.mockproject.ManagerRestaurant.view.DSmon;

public interface BillService {
	
	List<Bill> findAll();
	String getName(Integer id);
	List<Bill> getListBillByName(String name);
	List<String> getBillStatus();
	List<Bill> findBillByStatus(String status);
	Bill findBillById(int id);
	List<DSmon> getListProduct(int id);
	Bill save(Bill bill);
}
