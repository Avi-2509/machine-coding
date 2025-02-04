package com.machine_coding.Machine.coding.practice.lldQuestions.splitwise.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserExpense {
    private String ownerUserId;
    private String helperUserId;
    private Double amount;
}
