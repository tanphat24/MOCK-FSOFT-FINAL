package com.mockproject.ManagerRestaurant.service;

import java.util.List;
import java.util.Optional;

import com.mockproject.ManagerRestaurant.model.Tabble;

public interface TableService {
	public void addTable(Tabble table);
	public void updateTable(Tabble table);
	public void deleteTable(int tableId);
	public List<Tabble> getAllTable();
	public Tabble getByTableId(int tableId);
	public List<Tabble> getListTableEmpty();
}
