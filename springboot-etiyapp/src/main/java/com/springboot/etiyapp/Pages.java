package com.springboot.etiyapp;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Pages {

	@GetMapping("/index")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "index";
	}
	
	@GetMapping("/insert/city")
	public String CitySite(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "city";
	}
	
	@GetMapping("/insert/town")
	public String TownSite(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "town";
	}
	@GetMapping("/insert/branch")
	public String BranchSite(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "branch";
	}
	@GetMapping("/insert/employee")
	public String EmployeeSite(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "employee";
	}

}