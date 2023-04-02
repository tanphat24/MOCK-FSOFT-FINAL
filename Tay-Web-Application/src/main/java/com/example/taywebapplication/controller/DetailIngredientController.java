package com.example.taywebapplication.controller;

import com.example.taywebapplication.service.DetailIngredientService;
import com.example.taywebapplication.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DetailIngredientController {
    @Autowired
    private DetailIngredientService detailIngredientService;
    @Autowired
    private UnitService unitService;
    @GetMapping("/admin/listIngredient")
    public String showListProductForAdmin(Model model){
        model.addAttribute("listIngredient", detailIngredientService.getAllDetailIngredient());
        return "ingredientAdmin";
    }
}
