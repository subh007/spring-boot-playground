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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;


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
