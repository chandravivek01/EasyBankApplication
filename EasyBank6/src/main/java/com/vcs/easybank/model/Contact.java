package com.vcs.easybank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "contact_messages")
public class Contact {

    @Id
    private String contactId;

    private String contactName;

    private String contactEmail;

    private String subject;

    private String message;

    private Date createDate;
}
