package com.subh.app.h2db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @Column(name = "foreign_customer_id")
    Long customerId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(int totalBill) {
        this.totalBill = totalBill;
    }

    @Column(name = "total_bill")
    int totalBill;

    public Bill() {
    }
}
