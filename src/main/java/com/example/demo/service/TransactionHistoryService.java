package com.example.demo.service;

import com.example.demo.entity.TransactionHistory;
import com.example.demo.repository.TransactionHistoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionHistoryService {
    private final TransactionHistoryRepository transactionHistoryRepository;

    public TransactionHistoryService(TransactionHistoryRepository transactionHistoryRepository) {
        this.transactionHistoryRepository = transactionHistoryRepository;
    }

    public List<TransactionHistory> getAllTransactionHistories() {
        return transactionHistoryRepository.findAll();
    }

    public Optional<TransactionHistory> getTransactionHistoryById(Long id) {
        return transactionHistoryRepository.findById(id);
    }

    public TransactionHistory saveTransactionHistory(TransactionHistory transactionHistory) {
        return transactionHistoryRepository.save(transactionHistory);
    }

    public void deleteTransactionHistory(Long id) {
        transactionHistoryRepository.deleteById(id);
    }
} 