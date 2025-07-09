package com.example.demo.service;

import com.example.demo.entity.Bank;
import com.example.demo.entity.Branch;
import com.example.demo.repository.BankRepository;
import com.example.demo.repository.BranchRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BankService {
    private final BankRepository bankRepository;
    private final BranchRepository branchRepository;

    public BankService(BankRepository bankRepository, BranchRepository branchRepository) {
        this.bankRepository = bankRepository;
        this.branchRepository = branchRepository;
    }

    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    public List<Branch> getBranchesByBankId(Long bankId) {
        return branchRepository.findByBankId(bankId);
    }
} 