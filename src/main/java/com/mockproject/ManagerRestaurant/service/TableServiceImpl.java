package com.mockproject.ManagerRestaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockproject.ManagerRestaurant.model.Tabble;
import com.mockproject.ManagerRestaurant.repository.TableRepository;

@Service
public class TableServiceImpl implements TableService{
	
	@Autowired
	private TableRepository tableRepository;

	@Override
	public void addTable(Tabble table) {
		tableRepository.save(table);
	}

	@Override
	public void updateTable(Tabble table) {
		tableRepository.save(table);
	}

	@Override
	public void deleteTable(int tableId) {
		tableRepository.deleteById(tableId);
	}

	@Override
	public List<Tabble> getAllTable() {
		return tableRepository.findAll();
	}

	@Override
	public Tabble getByTableId(int tableId) {
		return tableRepository.findById(tableId).get();
	}

	@Override
	public List<Tabble> getListTableEmpty() {
		return tableRepository.getListTableEmpty();
	}

}
