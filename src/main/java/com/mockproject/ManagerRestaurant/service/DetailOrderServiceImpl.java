package com.mockproject.ManagerRestaurant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockproject.ManagerRestaurant.model.DetailOrder;
import com.mockproject.ManagerRestaurant.repository.DetailOrderRepository;
import com.mockproject.ManagerRestaurant.repository.OrderTableRepository;
import com.mockproject.ManagerRestaurant.repository.TableRepository;

@Service
public class DetailOrderServiceImpl implements DetailOrderService {
	@Autowired
	private DetailOrderRepository detailOrderRepository;
	@Autowired
	private OrderTableRepository orderTableRepository;
	@Autowired
	private TableRepository tableRepository;

	@Override
	public DetailOrder addDetailOrder(int idTable, int idProduct) {
		int idOrder = tableRepository.findById(idTable).get().getOrderTableId();
		List<DetailOrder> listDetailOrder = detailOrderRepository.checkDetailOrder(idOrder, idProduct);
		if (listDetailOrder.size() > 0) {
			DetailOrder detailOrder = listDetailOrder.get(0);
			detailOrder.setDetailOrderQuantity(detailOrder.getDetailOrderQuantity() + 1);
			return detailOrderRepository.save(detailOrder);
		} else {
			DetailOrder detailOrder = new DetailOrder();
			detailOrder.setOrderTableId(idOrder);
			detailOrder.setProductId(idProduct);
			detailOrder.setDetailOrderQuantity(1);
			detailOrder.setStatus(0);
			return detailOrderRepository.save(detailOrder);
		}
	}

	@Override
	public DetailOrder upadateDetailOrder(int idTable, int idProduct) {
		DetailOrder detailOrder = new DetailOrder();
		return detailOrderRepository.save(detailOrder);
	}

	@Override
	public List<DetailOrder> getListDetail(int idTable) {
		List<DetailOrder> list = new ArrayList<DetailOrder>();
		list.addAll(detailOrderRepository.getListDetailOrderByOrderTableId(idTable));
		return list;
	}

	@Override
	public List<DetailOrder> getListDetailByOrderTableId(Integer idTable) {
		List<DetailOrder> list = new ArrayList<DetailOrder>();

		list = detailOrderRepository
				.getListDetailOrderByOrderTableId(tableRepository.findById(idTable).get().getOrderTableId());
		System.out.println(tableRepository.findById(idTable).get());
		System.out.println("1----------------" + list);
		return list;
	}

	@Override
	public void deleteDetailOrder(int id) {
		detailOrderRepository.deleteById(id);
	}

	@Override
	public DetailOrder getDetailOrderById(int id) {
		return detailOrderRepository.findById(id).get();
	}

	@Override
	public void updateQuantityById(int id, int quantity) {
		DetailOrder detailOrder = detailOrderRepository.findById(id).get();
		detailOrder.setDetailOrderQuantity(quantity);
		detailOrderRepository.save(detailOrder);
	}

	@Override
	public DetailOrder updateDetailOrder(DetailOrder detailOrder) {
		return detailOrderRepository.save(detailOrder);
	}
}
