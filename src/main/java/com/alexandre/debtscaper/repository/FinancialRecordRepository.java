package com.alexandre.debtscaper.repository;

import com.alexandre.debtscaper.model.FinancialRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {
}