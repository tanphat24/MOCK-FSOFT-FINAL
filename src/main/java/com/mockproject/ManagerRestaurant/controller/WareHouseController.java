package com.mockproject.ManagerRestaurant.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mockproject.ManagerRestaurant.model.WareHouse;
import com.mockproject.ManagerRestaurant.service.WareHouseService;

@Controller
public class WareHouseController {
	
	@Autowired
	private WareHouseService service;
	
	@GetMapping("/WareHouse")
	public String WareHouse(Model m) {
		List<WareHouse> ware = service.getAllWareHouse();
		m.addAttribute("ware", ware);  
		return "WareHouse";	
	}
	
	@GetMapping("/add_WareHouse")
	public String add_WareHouseForm() {
		return "add_WareHouse";
	}
	
	@PostMapping("/add_Ware")
	public String wareHouse(@ModelAttribute WareHouse w, HttpSession session) {
		System.out.println(w);
		service.addWareHouse(w);
		session.setAttribute("msg", "Emplyoee Added Sucessfully..");
		return "redirect:/WareHouse";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		WareHouse ware = service.getWareHouseById(id);
		m.addAttribute("ware", ware);
		return "edit_WareHouse";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute WareHouse w, HttpSession session) {
		service.addWareHouse(w);
		session.setAttribute("msg", "Emp Data Update Sucessfully..");
		return "redirect:/WareHouse";
	}

	@GetMapping("/delete/{id}")
	public String deleteEMp(@PathVariable int id, HttpSession session) {
		service.deleteWareHouse(id);
		session.setAttribute("msg", "WareHouse Data Delete Sucessfully..");
		return "redirect:/WareHouse";
	}
}
