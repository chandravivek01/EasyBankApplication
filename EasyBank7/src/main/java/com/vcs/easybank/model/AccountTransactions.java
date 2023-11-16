package com.vcs.easybank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
public class AccountTransactions {

    @Id
    private String transactionId;

    private long accountNumber;

    private int customerId;

    private Date transactionDate;

    private String transactionSummary;

    private String transactionType;

    private int transactionAmount;

    private int closingBalance;

    private String createDate;
}
