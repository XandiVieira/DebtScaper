package com.alexandre.debtscaper.service;

import com.alexandre.debtscaper.model.FinancialRecord;

import java.util.List;

public interface FinanceService {
    List<FinancialRecord> getAllFinancialRecords();
    FinancialRecord getFinancialRecordById(Long id);
    FinancialRecord createFinancialRecord(FinancialRecord record);
    FinancialRecord updateFinancialRecord(Long id, FinancialRecord record);
    void deleteFinancialRecord(Long id);
}