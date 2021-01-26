package com.fyle.assignment.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "banks")
@Data
public class Bank {
    @Id
    private Integer id;
    private String name;
}
