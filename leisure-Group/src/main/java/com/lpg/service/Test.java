package com.lpg.service;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Test {
	
	public static void main(String[] args) {
		
	//System.out.println(ThreadLocalRandom.current().ints(0,100).distinct().limit(1).toString());
	
		final String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 5);
		System.out.println(uuid);
	
	}

}
