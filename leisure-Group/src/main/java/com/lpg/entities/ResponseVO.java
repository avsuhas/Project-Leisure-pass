package com.lpg.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseVO {
	
	private String status;
	private Long passId;

	public ResponseVO(String status, Long passId) {
		super();
		this.status = status;
		this.passId = passId;
	}
	

}
