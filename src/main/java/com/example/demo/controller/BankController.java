package com.example.demo.controller;

import com.example.demo.entity.Bank;
import com.example.demo.entity.Branch;
import com.example.demo.service.BankService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BankController {
    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/banks")
    public List<Bank> getAllBanks() {
        return bankService.getAllBanks();
    }

    @GetMapping("/branches")
    public List<Branch> getBranchesByBankId(@RequestParam("bank_id") Long bankId) {
        return bankService.getBranchesByBankId(bankId);
    }
} 