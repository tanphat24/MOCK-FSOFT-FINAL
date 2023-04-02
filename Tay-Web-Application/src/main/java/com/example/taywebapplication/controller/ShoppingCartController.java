package com.example.taywebapplication.controller;

import com.example.taywebapplication.model.Cart;
import com.example.taywebapplication.model.DetailOrder;
import com.example.taywebapplication.model.Product;
import com.example.taywebapplication.service.IDetailOrderService;
import com.example.taywebapplication.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ShoppingCartController {

    @Autowired
    private IDetailOrderService detailOrderService;
    @Autowired
    private IProductService productService;
    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }

//    @PostMapping("/shopping-cart")
//    public String Order(@ModelAttribute Cart cart){
//    }


//    @PostMapping("/them")
//    public String showOrder(@ModelAttribute Cart cart){
//        detailOrderService.save(cart);
//        System.out.println("aaa:"+cart);
//        return "product";
//    }

    @GetMapping("/order")
    public String showCreate(@RequestParam("id") int id , Model model){
        model.addAttribute("productOd",productService.getProductById(id));
        model.addAttribute("detail", new DetailOrder());

//        model.addAttribute()
        model.addAttribute("product", productService.getAll());
        return "orderConfirmation";
    }
    @PostMapping("/orderp")
    public String doCreate(@ModelAttribute("detail") DetailOrder detailOrder){
        detailOrderService.save(detailOrder);
        return "redirect:/product";
    }


}
