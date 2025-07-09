package com.example.demo.controller;

import com.example.demo.entity.TransactionHistory;
import com.example.demo.service.TransactionHistoryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transaction-histories")
public class TransactionHistoryController {
    private final TransactionHistoryService transactionHistoryService;

    public TransactionHistoryController(TransactionHistoryService transactionHistoryService) {
        this.transactionHistoryService = transactionHistoryService;
    }

    @GetMapping
    public List<TransactionHistory> getAllTransactionHistories() {
        return transactionHistoryService.getAllTransactionHistories();
    }

    @GetMapping("/{id}")
    public Optional<TransactionHistory> getTransactionHistoryById(@PathVariable Long id) {
        return transactionHistoryService.getTransactionHistoryById(id);
    }

    @PostMapping
    public TransactionHistory createTransactionHistory(@RequestBody TransactionHistory transactionHistory) {
        return transactionHistoryService.saveTransactionHistory(transactionHistory);
    }

    @PutMapping("/{id}")
    public TransactionHistory updateTransactionHistory(@PathVariable Long id, @RequestBody TransactionHistory transactionHistory) {
        transactionHistory.setId(id);
        return transactionHistoryService.saveTransactionHistory(transactionHistory);
    }

    @DeleteMapping("/{id}")
    public void deleteTransactionHistory(@PathVariable Long id) {
        transactionHistoryService.deleteTransactionHistory(id);
    }
} 