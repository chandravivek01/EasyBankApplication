package com.vcs.easybank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    @GetMapping("/myCard")
    public String getCardDetails() {
        return "Here are the card details of the A/C";
    }
}
