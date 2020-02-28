package com.lpg.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpg.entities.Customer;
import com.lpg.entities.ResponseVO;
import com.lpg.repo.CustomerRepo;

/**
 * @author suhasarudi
 *
 */
@Service
public class CustomerService implements ICustomerService{

	@Autowired
	CustomerRepo repository;
	
	/**Saving a new customer
	 * @param customer
	 * @return
	 */
	public Customer add(Customer customer) {
		return repository.save(toEntity(customer));
	}

	/**Populating Customer entity
	 * @param customer
	 * @return
	 */
	private Customer toEntity(Customer customer) {
		Customer entity = null;
		if(customer != null) {
		entity = new Customer();
		entity.setFirstName(customer.getFirstName());
		entity.setLastName(customer.getLastName());
		entity.setHomeCity(customer.getHomeCity());
		entity.setPassCity(customer.getPassCity());
		entity.setIssuedDate(LocalDateTime.now());
		entity.setExpiryDate(LocalDateTime.now().plusDays(30));		
		entity.setStatus("ACTIVE");	
		final String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 5);
		entity.setVendorId(uuid);
		}
		return entity;
	}
	
	/**To get customer by passId
	 * @param passId
	 * @return
	 * @throws CustomerNotFoundException
	 */
	public Customer getCustomerById(Long passId) throws CustomerNotFoundException{
		Optional<Customer> customer = repository.findById(passId);		
		return customer.orElseThrow(() -> new CustomerNotFoundException(passId));		
	}

	/**To renew customer pass with passId
	 * @param customerObj
	 * @param passId
	 * @return
	 * @throws CustomerNotFoundException
	 */
	public Customer renew(Customer customerObj, Long passId) throws CustomerNotFoundException {
		Optional<Customer> customerOp = repository.findById(passId);
		if(customerOp.isPresent()) {
			Customer customer = customerOp.get();
			LocalDateTime expiryDate = customer.getExpiryDate();
			LocalDateTime issuedDate = customer.getIssuedDate();
			if(isWithinRange(issuedDate, expiryDate)) {
				LocalDateTime currentExpiry = customer.getExpiryDate();
				customer.setExpiryDate(currentExpiry.plusDays(30));
				customer.setStatus(customerObj.getStatus());
				return repository.save(customer);
			}
		}
		return customerOp.orElseThrow(() -> new CustomerNotFoundException(passId));
		
	}
	
	/**To Cancel the pass
	 * @param customerObj
	 * @param passId
	 * @return
	 * @throws CustomerNotFoundException
	 */
	public  Customer cancelCustomerPass(Customer customerObj, Long passId) throws CustomerNotFoundException {
		Optional<Customer> customer = repository.findById(passId);
		if(customer.isPresent()){
			Customer renewedCustomer = customer.get();
			renewedCustomer.setStatus(customerObj.getStatus());
			return repository.save(renewedCustomer);
		}
		return customer.orElseThrow(() -> new CustomerNotFoundException(passId));	
		
	}

	/**Utility method 
	 * @param issuedDate
	 * @param expiryDate
	 * @return
	 */
	private boolean isWithinRange(LocalDateTime issuedDate, LocalDateTime expiryDate ) {
		   return LocalDateTime.now().isAfter(issuedDate) && LocalDateTime.now().isBefore(expiryDate);
	}
	

	/**To check valid pass
	 * @param passId
	 * @param vendorId
	 * @return
	 */
	public ResponseVO checkActive(Long passId, Long vendorId) {
		Optional<Customer> customerOp = repository.findByPassIdAndVendorId(passId,vendorId);
		if(customerOp.isPresent()) {
			Customer customer = customerOp.get();
			LocalDateTime expiryDate = customer.getExpiryDate();
			LocalDateTime issuedDate = customer.getIssuedDate();
			String status = customer.getStatus();
			 if(isWithinRange(issuedDate, expiryDate) && "ACTIVE".equalsIgnoreCase(status) ) {
				 return new ResponseVO("Valid Pass",passId); 
			 }
		}
		 return new ResponseVO("Invalid pass",passId); 
	}
	
}
