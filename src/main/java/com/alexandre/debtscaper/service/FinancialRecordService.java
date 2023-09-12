package com.alexandre.debtscaper.service;

import com.alexandre.debtscaper.model.FinancialRecord;
import com.alexandre.debtscaper.repository.FinancialRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinancialRecordService implements FinanceService {

    private final FinancialRecordRepository financialRecordRepository;

    @Autowired
    public FinancialRecordService(FinancialRecordRepository financialRecordRepository) {
        this.financialRecordRepository = financialRecordRepository;
    }

    @Override
    public List<FinancialRecord> getAllFinancialRecords() {
        return financialRecordRepository.findAll();
    }

    @Override
    public FinancialRecord getFinancialRecordById(Long id) {
        Optional<FinancialRecord> optionalRecord = financialRecordRepository.findById(id);
        return optionalRecord.orElse(null);
    }

    @Override
    public FinancialRecord createFinancialRecord(FinancialRecord financialRecord) {
        return financialRecordRepository.save(financialRecord);
    }

    @Override
    public FinancialRecord updateFinancialRecord(Long id, FinancialRecord financialRecord) {
        Optional<FinancialRecord> optionalExistingRecord = financialRecordRepository.findById(id);
        if (optionalExistingRecord.isPresent()) {
            FinancialRecord existingRecord = optionalExistingRecord.get();

            existingRecord.setDescription(financialRecord.getDescription());
            existingRecord.setAmount(financialRecord.getAmount());
            existingRecord.setDate(financialRecord.getDate());

            return financialRecordRepository.save(existingRecord);
        }
        return null;
    }

    @Override
    public void deleteFinancialRecord(Long id) {
        financialRecordRepository.deleteById(id);
    }
}