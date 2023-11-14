package com.vcs.easybank.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;

@Data
@Entity
@Table(name = "notice_details")
public class Notice {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int noticeId;

    private String noticeSummary;

    private String noticeDetails;

    private Date noticeBegDate;

    private Date noticeEndDate;

    private Date createDate;

    private Date updateDate;
}
