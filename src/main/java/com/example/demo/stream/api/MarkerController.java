package com.example.demo.stream.api;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MarkerController { 
	
	@GetMapping("/")
	public String hello(Model model, @RequestParam(value="name")String name) {
		model.addAttribute("name", name);
		return "hello";
	}
	
	@GetMapping("/fruits")
	public String fruits(Model model, @RequestParam(value="name")String name) {
		model.addAttribute("title", "Fruit Names");
		model.addAttribute("names", Arrays.asList("apple", "grape", "mango"));
		return "fruits";
	}
}
