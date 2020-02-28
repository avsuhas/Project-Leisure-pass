package com.lpg.service;

public class CustomerNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long passId;

	CustomerNotFoundException(Long id){
		super("Could not find customer "+ id);
		this.setPassId(id);
	}

	public Long getPassId() {
		return passId;
	}

	public void setPassId(Long passId) {
		this.passId = passId;
	}
	
}
