package com.example.taywebapplication.controller;

import com.example.taywebapplication.model.Cart;
import com.example.taywebapplication.model.DetailOrder;
import com.example.taywebapplication.model.Product;
import com.example.taywebapplication.service.IDetailOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ShoppingCartController {

    @Autowired
    private IDetailOrderService detailOrderService;
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

    @GetMapping("/orderp")
    public String showCreate(Model model){
        model.addAttribute("detail", new DetailOrder());
//        model.addAttribute()
//        model.addAttribute("typeProduct", typeProductService.getAll());
        return "aaaaa";
    }
    @PostMapping("/orderp")
    public String doCreate(@ModelAttribute("product") DetailOrder detailOrder){
        detailOrderService.save(detailOrder);
        return "redirect:/admin/listOrder";
    }


}
