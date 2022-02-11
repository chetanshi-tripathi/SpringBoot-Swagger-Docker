package com.demo.customer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.customer.model.Customer;

@Repository
public interface CustomerRepository  extends CrudRepository<Customer, Long> {

}
