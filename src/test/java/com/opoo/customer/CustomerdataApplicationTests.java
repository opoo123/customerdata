package com.opoo.customer;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.opoo.customer.entity.Customer;
import com.opoo.customer.repo.CustomerRepository;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class CustomerdataApplicationTests {

	@Autowired
	CustomerRepository customerRepository;
	
	@Test
	@Order(1)
	void contextLoads() {
	}
	
	@Test
	@Order(2)
	public void createTest() {
		Customer customer = new Customer();
		customer.setId(1);
		customer.setName("Jammy");
		customer.setEmail("xyz@xyz.com");
		customerRepository.save(customer);
	}
	
	
	@Test
	@Order(3)
	public void readTest() {
		Optional<Customer> customerOptional = customerRepository.findById(1);
		assertTrue(customerOptional.isPresent());
	}
	
	@Test
	@Order(4)
	public void updateTest() {
		Optional<Customer> customerOptional = customerRepository.findById(1);
		if(customerOptional.isPresent()) {
			Customer customer = customerOptional.get();
			customer.setEmail("xyzx@xyz.com");
			customerRepository.save(customer);
		}
	}
	
	@Test
	@Order(5)
	public void deleteTest() {
		if(customerRepository.existsById(1)) {
			customerRepository.deleteById(1);
		}
	}
	

}
