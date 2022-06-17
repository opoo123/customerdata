package com.opoo.customer.repo;

import org.springframework.data.repository.CrudRepository;

import com.opoo.customer.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
