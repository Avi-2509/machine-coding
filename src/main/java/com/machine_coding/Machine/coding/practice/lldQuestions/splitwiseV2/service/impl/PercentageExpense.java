package com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.service.impl;

import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.model.ExpenseRequest;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.model.Split;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.model.User;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.service.ExpenseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PercentageExpense extends ExpenseService {
    private final List<User> members;
    private final Map<String, Double> splits;

    public PercentageExpense(List<User> members, Map<String, Double> splits) {
        this.members = members;
        this.splits = splits;
    }

    @Override
    public List<Split> getSplits(ExpenseRequest expense) {
        List<Split> splitsList = new ArrayList<>();
        double totalAmount = expense.getTotalAmount();
        for (User member : members) {
            double amount = splits.get(member.getUserId()) * totalAmount / 100.0;
            splitsList.add(new Split(member, amount));
        }
        return splitsList;
    }
}
