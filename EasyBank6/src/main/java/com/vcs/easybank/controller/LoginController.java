package com.vcs.easybank.controller;

import com.vcs.easybank.model.Customer;
import com.vcs.easybank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {

        Customer savedCustomer = null;
        ResponseEntity response = null;
        try {
            String hashPassword = passwordEncoder.encode(customer.getPassword());
            customer.setPassword(hashPassword);
            customer.setCreateDate(String.valueOf(new Date(System.currentTimeMillis())));
            savedCustomer = customerRepository.save(customer);
            if ( savedCustomer.getId() > 0 )
                response = ResponseEntity.status(HttpStatus.CREATED).body("User details are successfully registered.");
        }
        catch (Exception exception) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to " + exception.getMessage());
        }
        return response;
    }

    @RequestMapping("/user")
    public Customer getUserDetailsAfterLogin(Authentication authentication) {

        List<Customer> customers = customerRepository.findByEmail(authentication.getName());
        return ( customers.size() > 0 ) ? customers.get(0) : null;
    }
}
