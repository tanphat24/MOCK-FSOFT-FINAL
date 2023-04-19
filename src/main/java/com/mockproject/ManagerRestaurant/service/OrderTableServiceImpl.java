package com.mockproject.ManagerRestaurant.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockproject.ManagerRestaurant.model.OrderTable;
import com.mockproject.ManagerRestaurant.model.Schedule;
import com.mockproject.ManagerRestaurant.model.Tabble;
import com.mockproject.ManagerRestaurant.repository.OrderTableRepository;


@Service
public class OrderTableServiceImpl implements OrderTableService{
	@Autowired
	private OrderTableRepository orderTableRepository;
	
	@Autowired
	private TableServiceImpl tableServiceImpl;
	
	@Autowired
	private ScheduleServiceImpl scheduleServiceImpl;

	@Override
	public void orderTableOffline(int idTable) {
		Tabble tabble = tableServiceImpl.getByTableId(idTable);
		if(tabble.getTableStatus().equals("Trống")) {
			Schedule schedule = new Schedule(new Date());
			int idSchedule = scheduleServiceImpl.addSchedule(schedule).getScheduleId();
			OrderTable orderTable = new OrderTable();
			orderTable.setNumberOfPeople(4);
			orderTable.setOrderTableDate(new Date());
			int idOrderTable = orderTableRepository.save(orderTable).getOrderTableId();
			tabble.setTableStatus("Đã có");
			tabble.setOrderTableId(idOrderTable);
			tabble.setScheduleId(idSchedule);
			tableServiceImpl.updateTable(tabble);
		}
	}

	@Override
	public boolean orderTableOnline(int idCustomer, String name, String email, int quantity, String phone, String date, String time, String note) {
		List<Tabble> listTable = tableServiceImpl.getAllTable();
		Date datetime = new Date();
		for (Tabble tabble : listTable) {
			if(tabble.getTableStatus().equals("Trống")) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				try {
					datetime = sdf.parse(date + " " + time);
				} catch (ParseException e) {
					
				}
				Schedule schedule = new Schedule(datetime);
				int idSchedule = scheduleServiceImpl.addSchedule(schedule).getScheduleId();
				OrderTable orderTable = new OrderTable();
				orderTable.setOrderTableDate(new Date());
				orderTable.setUserId(idCustomer);
				orderTable.setNumberOfPeople(quantity);
				orderTable.setOrderTableNote(note);
				int idOrderTable = orderTableRepository.save(orderTable).getOrderTableId();
				tabble.setTableStatus("Đã có");
				tabble.setOrderTableId(idOrderTable);
				tabble.setScheduleId(idSchedule);
				tableServiceImpl.updateTable(tabble);
				return true;
			}
		}
		return false;
	}

	@Override
	public OrderTable getOrderTableById(int id) {
		return orderTableRepository.findById(id).get();
	}

}
