package com.example.demo.repository;

import com.example.demo.entity.Branch;
import com.example.demo.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    List<Branch> findByBankId(Long bankId);
} 