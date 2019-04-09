package com.subh.app.h2db.controller;

import com.subh.app.h2db.model.Customer;
import com.subh.app.h2db.repository.CustomerRepository;
import com.subh.app.h2db.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    FileStorageService fileStorageService;

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

    // api for uploading pic
    @PostMapping(value = "/upload")
    public ResponseEntity<String> upload(@RequestParam("file")MultipartFile file) {
        try {
            fileStorageService.storeFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
