package com.example.taywebapplication.service;

import com.example.taywebapplication.model.Cart;
import com.example.taywebapplication.model.DetailOrder;

import java.util.List;

public interface IDetailOrderService {
    List<DetailOrder> getAll();
    public void save(DetailOrder detailOrder);
}
