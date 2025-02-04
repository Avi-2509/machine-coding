package com.machine_coding.Machine.coding.practice.lldQuestions.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends Base{
    private String name;
    private String email;
    private String passCode;
    private String phoneNumber;
    private String saltedPassword;
}
