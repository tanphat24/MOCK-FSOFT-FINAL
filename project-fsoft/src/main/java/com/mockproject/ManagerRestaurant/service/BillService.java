package com.mockproject.ManagerRestaurant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockproject.ManagerRestaurant.model.Bill;
import com.mockproject.ManagerRestaurant.repository.BillRepository;
import com.mockproject.ManagerRestaurant.view.DSmon;

@Service
public class BillService {
	@Autowired
	private BillRepository billRepository;
	
	public List<Bill> findAll() {
		return billRepository.findAll();
	}
	public String getName(Integer id) {
		String list = billRepository.getName(id);
		return list;
	}
	public List<Bill> getListBillByName(String name){
		return billRepository.getListBill(name);
	}
	public List<String> getBillStatus(){
		return billRepository.getStatus();
	}
	public List<Bill> findBillByStatus(String status){
		return billRepository.findByBillStatus(status);
	}
	public Bill findBillById(int id) {
		return billRepository.findByBillId(id);
	}
	public List<DSmon> getListProduct(int id) {
		List<String> list = billRepository.findProduct(id);
		List<DSmon> mons = new ArrayList<>();
		int i =1;
		try {
			for (String string : list) {
				String[] stringList = string.split(",");
				int quanity = Integer.parseInt(stringList[2]);
				DSmon mon = new DSmon(); 
				String product = billRepository.getProductById(Integer.parseInt(stringList[0]));
				String[] pro = product.split(",");
				Double price = Double.parseDouble(pro[2])*quanity;
				mon.setStt(i);
				mon.setName(pro[1]);
				mon.setSoluong(quanity);
				mon.setPrice(price);
				mons.add(mon);
				i++;
			}
		} catch (NumberFormatException | NullPointerException e) {
			e.printStackTrace();
		}
		return mons;
		
	}
	public Bill save(Bill bill) {
		return billRepository.save(bill);
	}
}
