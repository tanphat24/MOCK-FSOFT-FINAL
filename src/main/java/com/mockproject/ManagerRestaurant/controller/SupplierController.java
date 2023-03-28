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

import com.mockproject.ManagerRestaurant.service.SupplierService;
import com.mockproject.ManagerRestaurant.service.WareHouseService;
import com.mockproject.ManagerRestaurant.model.Supplier;
import com.mockproject.ManagerRestaurant.model.WareHouse; 

@Controller
public class SupplierController {
	@Autowired
	private SupplierService service;
	
	@Autowired
	private WareHouseService sw;
	
	@GetMapping("/Supplier")
	public String Supplier(Model m) {
		List<Supplier> sup = service.getAllSupplier();
		m.addAttribute("sup", sup);
		return "Supplier";
	}
	
	@GetMapping("/add_Supplier")
	public String add_SupplierForm() {
		return "add_Supplier";
	}
	
//	@PostMapping("/add_Sup")
//	public String supplier(@ModelAttribute Supplier s, HttpSession session, Model model,@ModelAttribute WareHouse w) {
//		System.out.println(s);
//		List<WareHouse> sup = sw.getAllWareHouse();
//		service.addRepo(s);
//		session.setAttribute("msg", "Supplier Added Sucessfully..");
//		return "redirect:/Supplier";
//	}
	
//	@GetMapping("/add_Supplier")
//	public String addSup(Model model) {
//		model.addAttribute("supplier", new Supplier());
////		model.addAttribute("sup", sw.getAllWareHouse());
//		return "add_Supplier";
//	}
	
	
	@PostMapping("add_Sup")
	public String doAdd(@ModelAttribute Supplier supplier) {
//		m.addAttribute("sup", sw.getAllWareHouse());
		service.addRepo(supplier);
		return "redirect:/Supplier";
	}
	@GetMapping("/editSup/{id}")
	public String editSup(@PathVariable int id, Model m) {
		Supplier sup = service.getSupplierById(id);
		m.addAttribute("sup", sup);
		return "edit_Supplier";
	}
	
	@PostMapping("/updateSup")
	public String updateSup(@ModelAttribute Supplier s, HttpSession session) {
		service.addRepo(s);
		session.setAttribute("msg", "Supplier Data Update Sucessfully..");
		return "redirect:/Supplier";
	}

	@GetMapping("/deleteSup/{id}")
	public String deleteSup(@PathVariable int id, HttpSession session) {
		service.deleteSupplier(id);
		session.setAttribute("msg", "Supplier Data Delete Sucessfully..");
		return "redirect:/Supplier";
	}
}