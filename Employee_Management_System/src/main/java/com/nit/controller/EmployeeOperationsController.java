package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nit.entity.Employee;
import com.nit.service.IEmployeeMgmtService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeOperationsController {
	@Autowired
	private IEmployeeMgmtService empService;
	
	@GetMapping("/")
	public String showEmployeeReport(Model model) {
		
		  List<Employee> list = empService.getAllEmp();
		  
		  model.addAttribute("empList", list);
		 
		return "show_employee_report";
	}
	
	@GetMapping("/addEmp")
	public String addEmployee() {
		return "save_employee";
	}
	
	@GetMapping("/editEmpDtls/{id}")
	public String editEmployeeReport(@PathVariable int id,Model model) {
		Employee emp = empService.getEmpById(id);
		model.addAttribute("emp", emp);
		return "edit_employee_report";
	}
	
	@PostMapping("/saveEmp")
	public String saveEmployee(@ModelAttribute Employee emp,HttpSession session) {
		Employee newEmp = empService.saveEmp(emp);
		
		if(newEmp != null) {
			session.setAttribute("msg", "Employee Added Sucessfully...");
		}else {
			session.setAttribute("msg", "Somthing wrong on server...");
		}
		return "redirect:/addEmp";
	}
	
	@PostMapping("/updateEmpDtls")
	public String updateEmp(@ModelAttribute Employee emp, HttpSession session) {
		Employee updateEmp = empService.saveEmp(emp);
		
		if(updateEmp != null) {
			session.setAttribute("msg", "Employee Update Sucessfully...");
		}else {
			session.setAttribute("msg", "Somthing wrong on server...");
		}
		return "redirect:/";
	}
	
	@GetMapping("/deleteEmp/{id}")
	public String removeEmployee(@PathVariable int id, HttpSession session) {
		boolean removeEmp = empService.deleteEmp(id);
		if(removeEmp) {
			session.setAttribute("msg", "Employee Delete...");
		}else {
			session.setAttribute("msg", "Somthing wrong server...");
		}
		return "redirect:/";
	}
}
