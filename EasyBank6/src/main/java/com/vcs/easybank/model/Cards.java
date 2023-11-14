package com.vcs.easybank.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;

@Data
@Entity
public class Cards {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int cardId;

    private int customerId;

    private String cardNumber;

    private String cardType;

    private int totalLimit;

    private int amountUsed;

    private int availableAmount;

    private Date createDate;
}
