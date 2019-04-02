package com.subh.app.h2db.repository;

import com.subh.app.h2db.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByName(String name);
}
