package com.phone.service;

import java.util.List;

import com.phone.entity.Customer;

public interface CustomerService {

	List<Customer> getAllCustomer();
	
	Customer saveCustomer(Customer student);
	
	Customer getCustomerById(Long id);
	
	Customer updateCustomer(Customer student);
	
	void deleteCustomerById(Long id);
}
