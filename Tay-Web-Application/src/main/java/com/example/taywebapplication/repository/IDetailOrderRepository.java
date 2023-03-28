package com.example.taywebapplication.repository;

import com.example.taywebapplication.model.DetailOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetailOrderRepository extends JpaRepository<DetailOrder,Integer> {
}
