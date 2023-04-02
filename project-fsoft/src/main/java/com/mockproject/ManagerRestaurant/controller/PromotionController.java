package com.mockproject.ManagerRestaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mockproject.ManagerRestaurant.model.Promotion;
import com.mockproject.ManagerRestaurant.service.PromotionService;

@Controller
public class PromotionController {
	@Autowired
	private PromotionService promotionService;
	
	@GetMapping("/listpromotion")
	public String listPromotion(Model model) {
		List<Promotion> list = promotionService.getAll();
		model.addAttribute("promotion", new Promotion());
		model.addAttribute("listpromotion", list);
		return "listpromotion";
	}
	@PostMapping("/addPromotion")
	public String doAddPromotion(@ModelAttribute("promotion") Promotion promotion, @RequestParam(name = "id") int id, Model model) {
		try {
			if(promotion.getPromoName()!=null) {
				promotion.setPromoId(id);
				System.out.println(promotion);
				promotionService.save(promotion);
				model.addAttribute("mess", "Thành công");
			}else {
				model.addAttribute("mess", "Thất bại");
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			model.addAttribute("mess", "Thất bại");
		}
		return "redirect:/listpromotion";
	}
	@GetMapping("/editPromotion")
	public String doEditPromotion(@RequestParam(name = "id") int id, Model model) {
		
		Promotion promotion = promotionService.getPromotionById(id);
		model.addAttribute("mess", "");
		model.addAttribute("promotion", promotion);
		List<Promotion> list = promotionService.getAll();
		model.addAttribute("listpromotion", list);
		return "listpromotion";
	}
	@GetMapping("/deletePromotion")
	public String doDeletePromotion(@RequestParam(name = "id") int id, Model model) {
		promotionService.deletePromotion(id);
		model.addAttribute("mess", "Xóa thành công");
		List<Promotion> list = promotionService.getAll();
		model.addAttribute("promotion", new Promotion());
		model.addAttribute("listpromotion", list);
		return "redirect:/listpromotion";
	}
}
