package com.example.demo_account;

import com.example.demo_account.model.Customer;
import com.example.demo_account.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sound.midi.Soundbank;
import java.util.HashSet;

@SpringBootApplication
public class DemoAccountApplication implements CommandLineRunner {
	private final CustomerRepository customerRepository;

	public DemoAccountApplication(CustomerRepository customerRepository){
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoAccountApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Customer customer = customerRepository.save(new Customer("", "Asu", "Besi", new HashSet<>()));
		Customer customer2 = customerRepository.save(new Customer("", "xyz", "asdfg", new HashSet<>()));
		System.out.println(customer);
		System.out.println(customer2);

	}

}
