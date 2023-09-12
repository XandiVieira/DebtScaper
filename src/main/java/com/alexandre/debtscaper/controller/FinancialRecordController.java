package com.alexandre.debtscaper.controller;

import com.alexandre.debtscaper.model.FinancialRecord;
import com.alexandre.debtscaper.service.FinancialRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/financial-records")
public class FinancialRecordController {
    private final FinancialRecordService financialRecordService;

    @Autowired
    public FinancialRecordController(FinancialRecordService financialRecordService) {
        this.financialRecordService = financialRecordService;
    }

    @GetMapping("/")
    public List<FinancialRecord> getAllFinancialRecords() {
        return financialRecordService.getAllFinancialRecords();
    }

    @GetMapping("/{id}")
    public FinancialRecord getFinancialRecord(@PathVariable Long id) {
        return financialRecordService.getFinancialRecordById(id);
    }

    @PostMapping("/")
    public FinancialRecord createFinancialRecord(@RequestBody FinancialRecord record) {
        return financialRecordService.createFinancialRecord(record);
    }

    @PutMapping("/{id}")
    public FinancialRecord updateFinancialRecord(@PathVariable Long id, @RequestBody FinancialRecord record) {
        return financialRecordService.updateFinancialRecord(id, record);
    }

    @DeleteMapping("/{id}")
    public void deleteFinancialRecord(@PathVariable Long id) {
        financialRecordService.deleteFinancialRecord(id);
    }
}