package com.fyle.assignment.controller;

import com.fyle.assignment.model.Bank;
import com.fyle.assignment.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class BankController {

    @Autowired
    private BankRepository bankRepository;

    @GetMapping("/api/bank")
    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }
}
