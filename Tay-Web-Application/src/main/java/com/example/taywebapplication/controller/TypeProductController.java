package com.example.taywebapplication.controller;

import com.example.taywebapplication.model.Product;
import com.example.taywebapplication.model.TypeProduct;
import com.example.taywebapplication.service.IProductService;
import com.example.taywebapplication.service.ITypeProductService;
import com.example.taywebapplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TypeProductController {
    @Autowired
    private ITypeProductService typeProductService;
    @Autowired
    private IProductService productService;
    @GetMapping("/{id}/detailTypeProduct")
    public String detailTypeProduct(@PathVariable TypeProduct id, Model model){
//        List<Product> productList = new ArrayList<>();
//        productList=productService.getProductByIdTypeProduct(id);
        model.addAttribute("listProduct", productService.getProductByIdTypeProduct(id));
        model.addAttribute("listTypeProduct",typeProductService.getAll());
        return "product";
    }
}
