package com.example.demo.controller;

import javax.servlet.http.HttpSession;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmpService;


@Controller

public class empcontroller {
     @Autowired
	private EmpService service;
	

	@GetMapping("/")
public String home(Model m) {
		
		
	List<Employee> emp =service.getAllEmp();
	m.addAttribute("emp",emp);
		
	return "index";
}
	@GetMapping("addemp")
	public String addEMP() {
		return "addemp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,HttpSession session) {
		
		System.out.println(e);
		
	 	service.addemp(e);
		session.setAttribute("msg", "Employee Added Successfully...");
		
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable  int id, Model m) {
		Employee e=service.getEmpById(id);
		m.addAttribute("emp",e);
		
		return "edit";
	}
	@PostMapping("/update")
   public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
	 service.addemp(e);
	 session.setAttribute("msg", "Emp update successful");
	 return "redirect:/";
	   
   }
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id, HttpSession session) {
		service.delete(id);
		session.setAttribute("msg", "Data deleted Successful");
		return "redirect:/";
	}
	
}
