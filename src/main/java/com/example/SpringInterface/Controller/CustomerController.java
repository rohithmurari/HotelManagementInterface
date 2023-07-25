package com.example.SpringInterface.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringInterface.Entity.Customer;
import com.example.SpringInterface.Service.CustomerService;



@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/")
	public ResponseEntity<?> getCustomers(){
		return ResponseEntity.ok(this.customerService.getCustomers());
	}
	
    @GetMapping("/api/customer/{customerId}")
		public Customer getCustomer(@PathVariable("customerId")Long customerId) throws Exception{
			return customerService.getCustomer(customerId);
		}
    
    @DeleteMapping("/{customerId}")
  		public void deleteCustomer(@PathVariable("customerId")Long customerId) throws Exception{
  			customerService.deleteCustomer(customerId);
  		}
    
    @PutMapping("/")
	public Customer updateCustomer(@RequestBody Customer customer) throws Exception{
		return customerService.updateCustomer(customer);
	}
    
    @PostMapping("/api/customer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws Exception{
		Customer customer1 = this.customerService.addCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(customer1);
	}
}
