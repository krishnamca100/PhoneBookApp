package com.phone.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.phone.entity.Customer;
import com.phone.repository.CustomerRepository;
import com.phone.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService{

	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public Customer saveCustomer(Customer student) {
		return customerRepository.save(student);
	}

	@Override
	public Customer getCustomerById(Long id) {
		return customerRepository.findById(id).get();
	}

	@Override
	public Customer updateCustomer(Customer student) {
		return customerRepository.save(student);
	}

	@Override
	public void deleteCustomerById(Long id) {
		customerRepository.deleteById(id);	
	}

}
