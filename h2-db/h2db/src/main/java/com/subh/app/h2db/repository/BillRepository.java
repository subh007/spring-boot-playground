package com.subh.app.h2db.repository;

import com.subh.app.h2db.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
