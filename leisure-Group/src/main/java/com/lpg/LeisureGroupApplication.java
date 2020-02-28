package com.lpg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lpg.repo.CustomerRepo;

@SpringBootApplication
public class LeisureGroupApplication implements CommandLineRunner{
	
	@Autowired
	CustomerRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(LeisureGroupApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	
	
	}

}
