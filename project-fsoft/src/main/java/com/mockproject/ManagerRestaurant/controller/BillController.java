package com.mockproject.ManagerRestaurant.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mockproject.ManagerRestaurant.model.Bill;
import com.mockproject.ManagerRestaurant.model.DSmon;
import com.mockproject.ManagerRestaurant.model.Method_payment;
import com.mockproject.ManagerRestaurant.model.viewbill;
import com.mockproject.ManagerRestaurant.service.BillService;
import com.mockproject.ManagerRestaurant.service.MethodPayService;

@Controller
public class BillController {
	@Autowired
	private BillService billService;
	@Autowired
	private MethodPayService methodPayService;
	
	@GetMapping("/listbill")
	public String getAllList(Model model) {
		List<viewbill> listbill = new ArrayList<>();
		List<Bill> bills = billService.findAll();
		List<String> strings = billService.getBillStatus();
		
		for (Bill bill : bills) {
			viewbill view = new viewbill();
			view.setID(bill.getBillId());
			view.setName(billService.getName(bill.getBillId()));
			view.setBillUpdate(bill.getBillUpdate());
			view.setBillTotal(bill.getBillTotal());
			view.setBillStatus(bill.getBillStatus());
			view.setBillCreate(bill.getBillCreate());
			view.setOrderTId(bill.getOrderTId());
			listbill.add(view);
		}
		model.addAttribute("listfilter", strings);
		model.addAttribute("billlist", listbill);
		return "listbill";
	}
	@GetMapping("/listbill/search")
	public String findBillByNameCustomer(@RequestParam("search") String search,Model model) {
		List<viewbill> listbill = new ArrayList<>();
		List<Bill> bills = billService.getListBillByName(search);
		List<String> strings = billService.getBillStatus();
		model.addAttribute("listfilter", strings);
		for (Bill bill : bills) {
			viewbill view = new viewbill();
			view.setID(bill.getBillId());
			view.setName(billService.getName(bill.getBillId()));
			view.setBillUpdate(bill.getBillUpdate());
			view.setBillTotal(bill.getBillTotal());
			view.setBillStatus(bill.getBillStatus());
			view.setBillCreate(bill.getBillCreate());
			view.setOrderTId(bill.getOrderTId());
			listbill.add(view);
		}
		model.addAttribute("billlist",listbill);
		return "listbill";
	}
	@GetMapping("/listbill/filter")
	public String findBillByStatus(@RequestParam("filterbill") String filter, Model model) {
		List<String> strings = billService.getBillStatus();
		List<viewbill> listbill = new ArrayList<>();
		List<Bill> bills = billService.findBillByStatus(filter);
		for (Bill bill : bills) {
			viewbill view = new viewbill();
			view.setID(bill.getBillId());
			view.setName(billService.getName(bill.getBillId()));
			view.setBillUpdate(bill.getBillUpdate());
			view.setBillTotal(bill.getBillTotal());
			view.setBillStatus(bill.getBillStatus());
			view.setBillCreate(bill.getBillCreate());
			view.setOrderTId(bill.getOrderTId());
			listbill.add(view);
		}
		model.addAttribute("billlist",listbill);
		model.addAttribute("listfilter", strings);
		return "listbill";
	}
	@GetMapping("/editbill/")
	public String editbill(@RequestParam(name = "id") Integer id,Model model) {
		Bill bill = billService.findBillById(id);
		List<Method_payment> pays = methodPayService.getList();
		viewbill view = new viewbill();
		view.setID(bill.getBillId());
		view.setName(billService.getName(bill.getBillId()));
		view.setBillUpdate(bill.getBillUpdate());
		view.setBillTotal(bill.getBillTotal());
		view.setBillStatus(bill.getBillStatus());
		view.setPromotion(bill.getPromotionId());
		view.setBillCreate(bill.getBillCreate());
		view.setMethodPayId(bill.getMethodPayId());
		view.setOrderTId(bill.getOrderTId());
		List<DSmon> mons = billService.getListProduct(bill.getOrderTId());
		List<String> status = billService.getBillStatus();
		Double price = 0.0;
		for (DSmon mon : mons) {
			price += mon.getPrice();
		}
		model.addAttribute("totalprice", price);
		model.addAttribute("listpay",pays);
		model.addAttribute("bill",view);
		model.addAttribute("listproduct", mons);
		model.addAttribute("listfilter", status);
		return "bill";
	}

}
