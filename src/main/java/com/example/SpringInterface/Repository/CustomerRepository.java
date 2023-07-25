package com.example.SpringInterface.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringInterface.Entity.Customer;



public interface CustomerRepository  extends JpaRepository<Customer,Long> {

}
