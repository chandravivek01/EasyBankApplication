package com.vcs.easybank.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;

@Data
@Entity
public class Loans {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int loanNumber;

    private int customerId;

    private Date startDate;

    private String loanType;

    private int totalLoan;

    private int amountPaid;

    private int outstandingAmount;

    private String createDate;
}
