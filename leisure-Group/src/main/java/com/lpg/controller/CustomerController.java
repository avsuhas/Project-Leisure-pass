package com.lpg.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpg.entities.Customer;
import com.lpg.entities.ResponseVO;
import com.lpg.service.CustomerNotFoundException;
import com.lpg.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {
	
	@Autowired
	CustomerService service;

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getInfo(@PathVariable Long passId) {
		try {
			Customer customerById = service.getCustomerById(passId);
			return ResponseEntity.ok().body(customerById);
		} catch (CustomerNotFoundException e) {
			log.error("unable to find the customer using passid={} ",passId,e);		
		}
		return ResponseEntity.notFound().build();		
	}
	
	@PostMapping("/add")
	public ResponseEntity<?>  addCustomer(@RequestBody Customer customer) throws URISyntaxException {
		Customer addCustomer = service.add(customer);
		return ResponseEntity.created(new URI("/customer/"+addCustomer.getPassId())).body(addCustomer);
	}
	
	@PatchMapping("/renew/{passId}")
	public ResponseEntity<Customer> renewPass(@RequestBody Customer renewCustomer, @PathVariable Long passId) {		 
		try {
			Customer renew = service.renew(renewCustomer, passId);
			return ResponseEntity.ok().body(renew);
		} catch (CustomerNotFoundException e) {
			log.error("unable to renew the customer using passid={} ",passId,e);
		}		
		return ResponseEntity.notFound().build();
	}
	
	@PatchMapping("/cancel/{passId}")
	public ResponseEntity<?> cancelPass(@RequestBody Customer cancelCustomer, @PathVariable Long passId){
		try {
			Customer cancelCustomerPass = service.cancelCustomerPass(cancelCustomer, passId);
			return ResponseEntity.ok().body(cancelCustomerPass);
		} catch (CustomerNotFoundException e) {
			log.error("Not a valid passid={} ",passId,e);		
			}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/status/{passId}/{vendorId}")
	public ResponseEntity<?> activePass(@PathVariable Long passId, @PathVariable Long vendorId){
		 ResponseVO response = service.checkActive(passId, vendorId);
		 return ResponseEntity.ok().body(response);
	}
	
	
}
