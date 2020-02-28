package com.lpg.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.lpg.entities.Customer;

/**
 * @author suhasarudi
 *
 */
public interface CustomerRepo extends CrudRepository<Customer, Long> {

	/**
	 * Find a customer by passId and vendorId
	 * @param passId
	 * @param vendorId
	 * @return
	 */
	Optional<Customer> findByPassIdAndVendorId(Long passId, Long vendorId);

}

