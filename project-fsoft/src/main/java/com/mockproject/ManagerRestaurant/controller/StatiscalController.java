package com.mockproject.ManagerRestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mockproject.ManagerRestaurant.service.BillService;

@Controller
public class StatiscalController {
	@Autowired
	private BillService billService;

}
