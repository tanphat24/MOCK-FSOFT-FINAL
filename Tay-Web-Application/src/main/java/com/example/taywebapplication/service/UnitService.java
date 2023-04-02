package com.example.taywebapplication.service;

import com.example.taywebapplication.model.Unit;
import com.example.taywebapplication.repository.IUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService implements IUnitService{
    @Autowired
    private IUnitRepository unitRepository;
    @Override
    public List<Unit> getAllUnit() {
        return unitRepository.findAll();
    }
}
