package com.vcs.easybank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Accounts {

    private int customerId;

    @Id
    private long accountNumber;

    private String accountType;

    private String branchAddress;

    private String createDate;
}
