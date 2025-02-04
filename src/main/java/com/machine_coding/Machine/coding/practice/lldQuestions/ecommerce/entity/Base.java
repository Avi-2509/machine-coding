package com.machine_coding.Machine.coding.practice.lldQuestions.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Base {
    private String id;
    private Integer status;
    private Date createdAt;
    private Date updatedAt;
}
