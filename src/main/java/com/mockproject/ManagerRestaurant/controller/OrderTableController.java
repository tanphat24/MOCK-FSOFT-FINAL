package com.mockproject.ManagerRestaurant.controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
import com.mockproject.ManagerRestaurant.model.OrderTable;
import com.mockproject.ManagerRestaurant.model.Product;
import com.mockproject.ManagerRestaurant.model.Schedule;
import com.mockproject.ManagerRestaurant.model.Tabble;
import com.mockproject.ManagerRestaurant.modelView.ProductOrder;
import com.mockproject.ManagerRestaurant.modelView.ProductView;
import com.mockproject.ManagerRestaurant.modelView.TableView;
import com.mockproject.ManagerRestaurant.service.DetailOrderService;
import com.mockproject.ManagerRestaurant.service.OrderTableService;
import com.mockproject.ManagerRestaurant.service.ProductService;
import com.mockproject.ManagerRestaurant.service.ScheduleServiceImpl;
import com.mockproject.ManagerRestaurant.service.TableService;

@Controller
public class OrderTableController {
	@Autowired
	private ScheduleServiceImpl scheduleServiceImpl;
	
	@Autowired
	private OrderTableService orderTableServiceImpl;
	
	@Autowired
	private DetailOrderService detailOrderService;
	
	@Autowired
	private TableService tableServiceImpl;

	@Autowired
	private ProductService productServiceImpl;

	@GetMapping("/user/bookTable")
	public String index() {
		return "/user/bookTable";
	}

	@GetMapping("/admin/orderTable")
	private String getAllTable(Model model) {
		List<TableView> listTableView = new ArrayList<>();
		List<Tabble> listTable = tableServiceImpl.getAllTable();
		Schedule schedule = new Schedule();
		OrderTable orderTable = new OrderTable();
		for (Tabble tabble : listTable) {
			List<DetailOrder> listDetailOrder = new ArrayList<>();	
			if(tableServiceImpl.getByTableId(tabble.getTableId()).getOrderTableId() != null) {
				System.out.println(tableServiceImpl.getByTableId(tabble.getTableId()).getOrderTableId());
				listDetailOrder = detailOrderService.getListDetailByOrderTableId(tabble.getTableId());
			}
			if(tabble.getScheduleId() != null) {		
				schedule = scheduleServiceImpl.getScheduleById(tabble.getScheduleId());
			}
			if(tabble.getOrderTableId() != null) {			
				orderTable = orderTableServiceImpl.getOrderTableById(tabble.getOrderTableId());
			}
			double total = 0;
			for (DetailOrder detailOrder : listDetailOrder) {
				Product product = productServiceImpl.getProductById(detailOrder.getProductId());
				total += detailOrder.getDetailOrderQuantity() * product.getProductPrice();
			}
			String totalVnd = new DecimalFormat("###,###,###").format(total) + " VNĐ";
			if(tabble.getScheduleId() == null || orderTable.getNumberOfPeople() == 0) {
				listTableView.add(new TableView(tabble.getTableId(), tabble.getTableName(), tabble.getTableStatus(), totalVnd, orderTable.getNumberOfPeople()));
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				listTableView.add(new TableView(tabble.getTableId(), tabble.getTableName(), tabble.getTableStatus(), totalVnd, sdf.format(schedule.getScheduleTimeStart()), orderTable.getNumberOfPeople()));
			}
		}
		
		model.addAttribute("listTable", listTableView);
		return "/admin/orderTable";
	}

	@GetMapping("/admin/orderProduct/{idTable}/products")
	private String getAllProduct(@PathVariable(value = "idTable") Integer idTable, Model model) {
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		List<ProductView> listProductView = new ArrayList<>();
		List<ProductOrder> listProductDetail = new ArrayList<ProductOrder>();
		orderTableServiceImpl.orderTableOffline(idTable);
		List<DetailOrder> listDetailOrder = detailOrderService.getListDetailByOrderTableId(idTable);
		System.out.println(listDetailOrder.size());
		for (DetailOrder detailOrder : listDetailOrder) {
			if (detailOrder != null) {
				Product product = productServiceImpl.getProductById(detailOrder.getProductId());
				ProductOrder productOrder = new ProductOrder(detailOrder.getOrderDetailId(), product.getProductId(), product.getProductName(), formatter.format(product.getProductPrice()) + " VNĐ", product.getProductDescription(), product.getProductImage(), product.getTypeProductId(), detailOrder.getDetailOrderQuantity(), formatter.format(detailOrder.getDetailOrderQuantity() * product.getProductPrice()) + " VNĐ");
				listProductDetail.add(productOrder);
			}
		}
		for (Product product : productServiceImpl.getAllProduct()) {
			listProductView.add(new ProductView(product.getProductId(), product.getProductName(), formatter.format(product.getProductPrice()) + " VNĐ", product.getProductDescription(), product.getProductImage(), product.getTypeProductId()));
		}
		model.addAttribute("tableName", tableServiceImpl.getByTableId(idTable).getTableName());
		model.addAttribute("listProduct", listProductView);
		model.addAttribute("listDetailOrder", listProductDetail);
		return "/admin/orderProduct";
	}
	
	@PostMapping("/user/handleBookTable")
	private String handleBookTable(Model model, HttpServletRequest req) {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		String phone = req.getParameter("phone");
		String date = req.getParameter("date");
		String time = req.getParameter("time");
		String note = req.getParameter("note");
		
		orderTableServiceImpl.orderTableOnline(1, name, email, quantity, phone, date, time, note);
		
		return "redirect:/user/bookTable";
	}
	
}
