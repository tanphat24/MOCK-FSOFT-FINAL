package com.example.taywebapplication.controller;

import com.example.taywebapplication.model.Cart;
import com.example.taywebapplication.model.DetailOrder;
import com.example.taywebapplication.model.Product;
import com.example.taywebapplication.service.IDetailOrderService;
import com.example.taywebapplication.service.IProductService;
import com.example.taywebapplication.service.ITypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private ITypeProductService typeProductService;
    @Autowired
    private IProductService productService;
    @Autowired
    private IDetailOrderService detailOrderService;
//    @GetMapping("/list")
//    public String showListProduct(Model model){
//        model.addAttribute("listProduct", productService.getAll());
//        model.addAttribute("listTypeProduct",typeProductService.getAll());
//        return "product";
//    }
    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }
    @GetMapping("/product")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/product");
        modelAndView.addObject("listProduct", productService.getAll());
        modelAndView.addObject("listTypeProduct",typeProductService.getAll());
        return modelAndView;
    }
    @GetMapping("/admin/list")
    public String showListProductForAdmin(Model model){
        model.addAttribute("listProduct", productService.getAll());
        return "productForAdmin";
    }
    @GetMapping("/admin/typelist")
    public String showListTypeProductForAdmin(Model model){
        model.addAttribute("listTypeProduct",typeProductService.getAll());
        return "typeProductForAdmin";
    }
    @GetMapping("/admin/create")
    public String showCreate(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("typeProduct", typeProductService.getAll());
        return "createProduct";
    }
    @PostMapping("/admin/create")
    public String doCreate(@ModelAttribute("product") Product product){
        productService.addNewProduct(product);
        return "redirect:/admin/list";
    }
    @GetMapping("/admin/{id}/delete")
    public String deleteProduct(@PathVariable int id, Model model){
//        productService.getProductById(id);
        productService.deleteProduct(id);
        return "redirect:/admin/list";
    }
    @GetMapping("/admin/update")
    public String update(@RequestParam("id") int id , Model model){
        model.addAttribute("product",productService.getProductById(id));
        model.addAttribute("typeProduct",typeProductService.getAll());
        return "updateProductForAdmin";
    }
    @PostMapping("/admin/update")
    public String update(@ModelAttribute("product") Product product){
        productService.addNewProduct(product);
        return "redirect:/admin/list";
    }
    @GetMapping("/add/{id}")
    public Object addToCart(@PathVariable int id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = Optional.ofNullable(productService.getProductById(id));
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
//            return "redirect:/shopping-cart";
//            String s = "redirect:/shopping-cart";
            return new ResponseEntity<>(productOptional.get().getQuantity(), HttpStatus.NO_CONTENT);
        }
        cart.addProduct(productOptional.get());
//        return "redirect:/product";
        return new ResponseEntity<>(productOptional.get(), HttpStatus.NO_CONTENT);
    }


    @PostMapping("/search")
    public String search(@RequestParam("search") String search, Model model){
        model.addAttribute("listTypeProduct",typeProductService.getAll());
        model.addAttribute("listProduct",productService.search(search));
        return "product";
    }

//    @GetMapping("/order")
//    public String order(@RequestParam("id") int id , Model model){
//        model.addAttribute("product",productService.getProductById(id));
//        model.addAttribute("detail", new DetailOrder());
////        model.addAttribute("typeProduct",typeProductService.getAll());
//        return "aaaaa";
//    }
//
//    @PostMapping("/orderp")
//    public String doCreate(@ModelAttribute("product") DetailOrder detailOrder){
//        detailOrderService.save(detailOrder);
//        return "redirect:/admin/listOrder";
//    }

}
