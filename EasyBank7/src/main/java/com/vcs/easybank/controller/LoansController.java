package com.vcs.easybank.controller;


import com.vcs.easybank.model.Loans;
import com.vcs.easybank.repository.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoansRepository loansRepository;

    @GetMapping("/myLoans")
    public List<Loans> getLoanDetails(@RequestParam int id) {

        return loansRepository.findByCustomerIdOrderByStartDateDesc(id);
    }
}
