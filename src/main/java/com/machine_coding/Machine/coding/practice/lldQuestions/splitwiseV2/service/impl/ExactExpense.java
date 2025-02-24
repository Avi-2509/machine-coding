package com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.service.impl;

import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.model.ExpenseRequest;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.model.Split;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.model.User;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.service.ExpenseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExactExpense extends ExpenseService {
    private final List<User> members;
    private final Map<String, Double> splits;

    public ExactExpense(List<User> members, Map<String, Double> splits) {
        this.members = members;
        this.splits = splits;
    }

    @Override
    public List<Split> getSplits(ExpenseRequest expense) {
        List<Split> splitsList = new ArrayList<>();
        for (User member : members) {
            double amount = splits.getOrDefault(member.getUserId(), 0.0);
            splitsList.add(new Split(member, amount));
        }
        return splitsList;
    }
}
