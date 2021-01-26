package com.fyle.assignment.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "branches")
@Data
public class Branch {
    @Id
    @Column(name = "ifsc")
    private String bankIFSC;
    @Column(name = "bank_id")
    private Integer bankId;
    @Column(name = "branch")
    private String bankBranch;
    @Column(name = "address")
    private String bankAddress;
    @Column(name = "city")
    private String bankCity;
    @Column(name = "district")
    private String bankDistrict;
    @Column(name = "state")
    private String bankState;
}
