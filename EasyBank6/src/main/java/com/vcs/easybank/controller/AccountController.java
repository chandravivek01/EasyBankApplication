package com.vcs.easybank.controller;

import com.vcs.easybank.model.Accounts;
import com.vcs.easybank.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountsRepository accountsRepository;

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam int id) {

        return accountsRepository.findByCustomerId(id);
    }

}
