package com.mockproject.ManagerRestaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockproject.ManagerRestaurant.model.Method_payment;
import com.mockproject.ManagerRestaurant.repository.MethodPayRepository;

@Service
public class MethodPayServiceImpl implements MethodPayService {
	@Autowired
	private MethodPayRepository methodPayRepository;
	public List<Method_payment> getList(){
		return methodPayRepository.findAll();
	}
}
