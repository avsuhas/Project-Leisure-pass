package com.lpg.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author suhasarudi
 *
 */
@Entity
@Data
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long passId;
	private String firstName;
	private String lastName;
	private String homeCity;
	private String passCity;
	private LocalDateTime issuedDate;
	private LocalDateTime expiryDate;
	private String status;
	private String vendorId;
	
	
}
