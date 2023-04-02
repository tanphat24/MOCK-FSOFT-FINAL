package com.example.taywebapplication.service;

import com.example.taywebapplication.model.Cart;
import com.example.taywebapplication.model.DetailOrder;
import com.example.taywebapplication.repository.IDetailOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("detailOderService")
public class DetailOrderService implements IDetailOrderService {
    @Autowired
    private IDetailOrderRepository detailOrderRepository;

    @Override
    public List<DetailOrder> getAll() {
        return detailOrderRepository.findAll();
    }

    @Override
    public void save(DetailOrder detailOrder) {
        detailOrderRepository.save(detailOrder);
    }
}
