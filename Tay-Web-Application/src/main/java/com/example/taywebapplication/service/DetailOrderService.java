package com.example.taywebapplication.service;

import com.example.taywebapplication.model.DetailOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("detailOderService")
public class DetailOrderService implements IDetailOrderService {

    @Override
    public List<DetailOrder> getAll() {
        return null;
    }

    @Override
    public void save(DetailOrder detailOrder) {

    }
}
