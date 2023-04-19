package com.mockproject.ManagerRestaurant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mockproject.ManagerRestaurant.model.DetailOrder;
import com.mockproject.ManagerRestaurant.model.OrderTable;
import com.mockproject.ManagerRestaurant.model.Tabble;
import com.mockproject.ManagerRestaurant.service.DetailOrderService;
import com.mockproject.ManagerRestaurant.service.TableService;

@Controller
public class TableController {

	@Autowired
	TableService tableService;

	@Autowired
	DetailOrderService detailOrderService;

	@GetMapping("/admin/managerTable")
	private String getAllTable(Model model) {
		model.addAttribute("listTable", tableService.getAllTable());
		return "admin/managerTable";
	}

	@PostMapping("/admin/saveTable")
	private String saveTable(@ModelAttribute("tabble") Tabble tabble, Model model) {
		tabble.setTableStatus("Trống");
		tableService.addTable(tabble);
		model.addAttribute("listTable", tableService.getAllTable());
		return "redirect:/admin/managerTable";
	}

	@GetMapping("/admin/deleteTable/{id}")
	public String deleteTable(@PathVariable(value = "id") Integer id, Model model) {
		tableService.deleteTable(id);
		return "redirect:/admin/managerTable";
	}

	@GetMapping("/admin/formUpdateTable/{id}")
	private String formUpdate(@PathVariable(value = "id") Integer id, Model model) {
		Tabble tabble = tableService.getByTableId(id);
		model.addAttribute("table", tabble);
		return "admin/updateTable";
	}

	@PostMapping("/admin/changeTable")
	private String changeTable(Model model, HttpServletRequest req) {
		int idFromTable = Integer.parseInt(req.getParameter("fromTable"));
		int idToTable = Integer.parseInt(req.getParameter("toTable"));

		List<DetailOrder> list = detailOrderService.getListDetailByOrderTableId(idToTable);

		Integer idOrderTable = tableService.getByTableId(idFromTable).getOrderTableId();

		System.out.println(">>>>>>>>>>>>>>" + idFromTable);
		System.out.println(">>>>>>>>>>>>>>" + idToTable);
		System.out.println(">>>>>>>>>>>>>>" + list);

		if(idOrderTable != null) {			
			Tabble fromTable = tableService.getByTableId(idFromTable);
			Tabble toTable = tableService.getByTableId(idToTable);
			
			toTable.setOrderTableId(fromTable.getOrderTableId());
			toTable.setScheduleId(fromTable.getScheduleId());
			toTable.setTableStatus("Đã có");
			
			fromTable.setOrderTableId(null);
			fromTable.setScheduleId(null);
			fromTable.setTableStatus("Trống");
			
			for (DetailOrder detailOrder : list) {
				System.out.println("################" + idOrderTable);
				System.out.println("################D" + detailOrder.getOrderTableId());
				detailOrder.setOrderTableId(idOrderTable);
				detailOrderService.updateDetailOrder(detailOrder);
				
			}
			
			System.out.println("hhhhhh");
			tableService.updateTable(fromTable);
			tableService.updateTable(toTable);
			
		}
		return "redirect:/admin/orderTable";
	}

	@PostMapping("/admin/cancelTable")
	private String cancelTable(Model model, HttpServletRequest req) {
		int idCancelTable = Integer.parseInt(req.getParameter("idCancelTable"));
		Tabble tabble = tableService.getByTableId(idCancelTable);

		tabble.setOrderTableId(null);
		tabble.setScheduleId(null);
		tabble.setTableStatus("Trống");
		tableService.updateTable(tabble);

		List<DetailOrder> listDetailOrder = detailOrderService.getListDetailByOrderTableId(idCancelTable);
		for (DetailOrder detailOrder : listDetailOrder) {
			detailOrderService.deleteDetailOrder(detailOrder.getOrderDetailId());
		}

		return "redirect:/admin/orderTable";
	}
}
