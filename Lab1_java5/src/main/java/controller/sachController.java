package com.fpoly.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpoly.model.Sach;
import com.fpoly.service.sachService;

@Controller
@RequestMapping("/sach")
public class sachController {
	
	public final sachService sachService;
	public sachController(sachService sachService) {
		this.sachService = sachService;
	}
	
	@GetMapping("/hienthi")
	public String hienthi(Model model) {
		List<Sach>ListSach = sachService.getAllSach();
		model.addAttribute("sach",new Sach());
		model.addAttribute("ListSach",ListSach);
		model.addAttribute("title","trang chủ sách");
		model.addAttribute("content","sach/home");
		return "layout/base";
	}
	
	@PostMapping("/add")
	public String them(@ModelAttribute("sach")Sach Sach) {
		sachService.createProduct(Sach);
		return"redirect:/sach/hienthi";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")int id) {
		sachService.delete(id);
		return"redirect:/sach/hienthi";
	}
}
