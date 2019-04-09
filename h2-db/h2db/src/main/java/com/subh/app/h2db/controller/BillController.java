package com.subh.app.h2db.controller;

import com.subh.app.h2db.model.Bill;
import com.subh.app.h2db.model.Customer;
import com.subh.app.h2db.repository.BillRepository;
import com.subh.app.h2db.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    BillRepository billRepository;

    @Autowired
    CustomerRepository customerRepository;

    @PutMapping(value = "/addbill")
    public List<Bill> saveBill(@RequestBody Bill bill) {
        String name = bill.getCustomer().getName();
        Customer customer = customerRepository.findByName(name);

        if (customer == null) {
            billRepository.save(bill);
        } else {
            bill.setCustomer(customer);
            billRepository.save(bill);
        }
        return billRepository.findAll();
    }
}
