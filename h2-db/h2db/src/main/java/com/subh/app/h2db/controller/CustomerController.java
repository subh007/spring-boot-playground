package com.subh.app.h2db.controller;

import com.subh.app.h2db.model.Customer;
import com.subh.app.h2db.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/all")
    public List<Customer> findAll() {
        System.out.println("== received get all request  -===");
        return customerRepository.findAll();
    }


    @GetMapping(value = "/{name}")
    public Customer getCustomer(@PathVariable("name") String name) {
        return customerRepository.findByName(name);
    }

    @PostMapping(value = "/add")
    public Customer addCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return customerRepository.findByName(customer.getName());
    }
}
