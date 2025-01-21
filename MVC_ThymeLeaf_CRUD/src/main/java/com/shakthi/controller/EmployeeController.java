package com.shakthi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shakthi.entity.Employee;
import com.shakthi.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("register")
	public String regPage() {
		return "EmployeeRegister";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Employee emp, Model model) {
		Integer id = service.saveEmployee(emp);
		String msg = "Employee ' " + id + " ' Created";
		model.addAttribute("message", msg);
		return "EmployeeRegister";
	}

	@GetMapping("/all")
	public String getAll(@RequestParam(required = false) String message, Model model) {

		List<Employee> listOfEmployee = service.getAllEmployees();
		model.addAttribute("list", listOfEmployee);
		model.addAttribute("message", message);
		return "EmployeeData";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		Employee emp = service.getOneEmployee(id);
		model.addAttribute("employee", emp);
		return "EmployeeEdit";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id, RedirectAttributes attribute) {
		service.deleteEmployee(id);
		attribute.addAttribute("message", "Employee of Id : ' " + id + " ' deleted");
		return "redirect:all";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute Employee emp, RedirectAttributes attribute) {
		service.updateEmployee(emp);
		attribute.addAttribute("message", "Employee of Id : ' " + emp.getEmpId() + "' updated..");
		return "redirect:all";
	}

}
