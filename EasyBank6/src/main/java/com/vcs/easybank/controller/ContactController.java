package com.vcs.easybank.controller;

import com.vcs.easybank.model.Contact;
import com.vcs.easybank.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.Random;

@RestController
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @PostMapping("/contact")
    public Contact saveContactInquiryDetails(@RequestBody Contact contact) {

        contact.setContactId(getServiceReqNumber());
        contact.setCreateDate(new Date(System.currentTimeMillis()));
        return contactRepository.save(contact);
    }

    public String getServiceReqNumber() {

        Random random = new Random();
        int randomNum = random.nextInt(999_999_999 - 9_999) + 9_999;
        return "SR" + randomNum;
    }
}
