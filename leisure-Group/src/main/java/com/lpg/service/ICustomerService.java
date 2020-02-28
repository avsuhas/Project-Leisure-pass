package com.lpg.service;

import com.lpg.entities.Customer;
import com.lpg.entities.ResponseVO;

/**
 * @author suhasarudi
 *
 */
public interface ICustomerService {
	
	public Customer add(Customer customer);
	
	public Customer getCustomerById(Long passId) throws CustomerNotFoundException;
	
	public Customer renew(Customer customerObj, Long passId) throws CustomerNotFoundException;
	
	public  Customer cancelCustomerPass(Customer customerObj, Long passId) throws CustomerNotFoundException;
	
	public ResponseVO checkActive(Long passId, String vendorId);


}
