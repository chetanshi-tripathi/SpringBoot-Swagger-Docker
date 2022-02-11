package com.demo.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.customer.model.Customer;
import com.demo.customer.repository.CustomerRepository;
import com.google.common.base.Optional;



@RestController
@RequestMapping("/customer")
public class CustomerAPI {

	@Autowired
	CustomerRepository custRepository;
	
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Customer customer)
	{
		Customer newCustomer = new Customer();
		newCustomer.setName(customer.getName());
		newCustomer.setContact(customer.getContact());
		newCustomer.setEmail(customer.getEmail());
		custRepository.save(newCustomer);
		return new ResponseEntity<String>("Added record to the table with id:"+newCustomer.getId(), HttpStatus.OK);
			
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getById(@PathVariable Long id)
	{
		java.util.Optional<Customer> custOptional= custRepository.findById(id);
		if(custOptional.isPresent()) {
			return new ResponseEntity<Customer>(custOptional.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Customer>> getAll(){
		List<Customer> customer = (List<Customer>) custRepository.findAll();
		if(customer.isEmpty()) {
			return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Customer>>(customer, HttpStatus.OK);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Customer customer){
		java.util.Optional<Customer> custOptional = custRepository.findById(id);
		if(custOptional.isPresent()) {
			
			
			custOptional.get().setEmail(customer.getEmail());
			custOptional.get().setName(customer.getName());
			custOptional.get().setName(customer.getName());
			custRepository.save(custOptional.get());
			return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> update(@PathVariable Long id){
		java.util.Optional<Customer> customer = custRepository.findById(id);
		if(customer.isPresent()) {
			custRepository.delete(customer.get());
			return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	
	
}
