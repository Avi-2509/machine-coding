package com.machine_coding.Machine.coding.practice.lldQuestions.splitwise.model;

import com.machine_coding.Machine.coding.practice.lldQuestions.splitwise.services.ISplitStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Expense {
    private String id;
    private double amount;
    private String description;
    private User paidBy;
    private ISplitStrategy splitStrategy;
}
