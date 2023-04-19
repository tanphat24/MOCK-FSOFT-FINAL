package com.mockproject.ManagerRestaurant.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mockproject.ManagerRestaurant.model.DetailOrder;
import com.mockproject.ManagerRestaurant.model.Product;
import com.mockproject.ManagerRestaurant.modelView.ProductView;
import com.mockproject.ManagerRestaurant.service.DetailOrderService;
import com.mockproject.ManagerRestaurant.service.ProductServiceImpl;
import com.mockproject.ManagerRestaurant.service.TableServiceImpl;

@Controller
public class DetailOrderController {
	
	@Autowired
	private DetailOrderService detailOrderService;
	
	@Autowired
	private TableServiceImpl tableServiceImpl;
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@GetMapping("/admin/orderProduct/{idTable}/products/{idProduct}")
	private String addOrderTable(@PathVariable(value = "idTable") Integer idTable, @PathVariable(value = "idProduct") Integer idProduct, Model model) {
		detailOrderService.addDetailOrder(idTable, idProduct);
		model.addAttribute("listProduct", productServiceImpl.getAllProduct());
		return "redirect:/admin/orderProduct/{idTable}/products";
	}
	
	@GetMapping("/admin/delete/{idTable}/detailOrderTable/{detailOrderId}")
	private String deleteOrderTable(@PathVariable(value = "detailOrderId") Integer detailOrderId, Model model) {
		detailOrderService.deleteDetailOrder(detailOrderId);
		return "redirect:/admin/orderProduct/{idTable}/products";
	}
	
	@PostMapping("/admin/update/{idTable}/detailOrderTable")
	private String updateOrderTable(@PathVariable(value = "idTable") Integer idTable ,Model model, HttpServletRequest request) {
		List<DetailOrder> listDetailOrder = detailOrderService.getListDetailByOrderTableId(idTable);
		for (DetailOrder detailOrder : listDetailOrder) {
			int quantity = Integer.parseInt(request.getParameter("quantity" + detailOrder.getOrderDetailId()));
			int id = Integer.parseInt(request.getParameter("idDetailOrder" + detailOrder.getOrderDetailId()));
			detailOrderService.updateQuantityById(id, quantity);
		}
		return "redirect:/admin/orderProduct/{idTable}/products";
	}
}
