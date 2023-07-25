package com.example.SpringInterface.Service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.SpringInterface.Entity.Customer;
import com.example.SpringInterface.Repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Set<Customer> getCustomers() {
		HashSet<Customer> forObject = restTemplate.getForObject("http://localhost:8080/", HashSet.class);
		return forObject; 
//		System.out.println(forObject);
//		for(Customer c : forObject) {
//			this.customerRepository.save(c);
//		}
//		
//		return new HashSet<>(this.customerRepository.findAll());
	}
	
	public Customer getCustomer(Long customerId) {
		Customer customer = restTemplate.getForObject("http://localhost:8080/api/customer/"+customerId, Customer.class);
		String fullName = customer.getFirstName() + " " + customer.getLastName();
		customer.setFullName(fullName);
		return customer;
	}
	
	public Customer updateCustomer(Customer customer) {
//		Customer customer1 = restTemplate.put("http://localhost:8080/", Customer.class);
		restTemplate.put("http://localhost:8080/", customer);
		return customer;
	}
	
	public void deleteCustomer(Long customerId) {
		restTemplate.delete("http://localhost:8080/"+customerId);
	
	}
	
	public Customer addCustomer(Customer customer) throws Exception {
		Customer customer1 = restTemplate.postForObject("http://localhost:8080/api/customer", customer, Customer.class);
		return customer1;
	}
	
}
