package com.phone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.phone.entity.Customer;
import com.phone.service.CustomerService;


@Controller
public class CustomerController {
	
	private CustomerService custService;

	public CustomerController(CustomerService custService) {
		super();
		this.custService = custService;
	}
	
	@GetMapping("/customers")
	public String listStudents(Model model) {
		model.addAttribute("customers", custService.getAllCustomer());
		return "customers";
	}
	
	@GetMapping("/customers/new")
	public String createStudentForm(Model model) {
		
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "create_customer";
		
	}
	
	@PostMapping("/customers")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		custService.saveCustomer(customer);
		return "redirect:/customers";
	}
	
	@GetMapping("/customers/edit/{id}")
	public String editCustomerForm(@PathVariable Long id, Model model) {
		model.addAttribute("customer", custService.getCustomerById(id));
		return "edit_customer";
	}

	@PostMapping("/customers/{id}")
	public String updateCustomer(@PathVariable Long id,
			@ModelAttribute("customer") Customer customer,
			Model model) {
		
		Customer existingCustomer = custService.getCustomerById(id);
		existingCustomer.setId(id);
		existingCustomer.setFirstName(customer.getFirstName());
		existingCustomer.setLastName(customer.getLastName());
		existingCustomer.setPhoneNumber(customer.getPhoneNumber());
		
		custService.updateCustomer(existingCustomer);
		return "redirect:/customers";		
	}
	
	
	@GetMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		custService.deleteCustomerById(id);
		return "redirect:/customers";
	}
	
}
