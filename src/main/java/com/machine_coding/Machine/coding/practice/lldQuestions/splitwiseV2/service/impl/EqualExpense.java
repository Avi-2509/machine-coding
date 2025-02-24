package com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.service.impl;

import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.model.ExpenseRequest;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.model.Split;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.model.User;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.service.ExpenseService;

import java.util.ArrayList;
import java.util.List;

public class EqualExpense extends ExpenseService {
	private final List<User> members;

	public EqualExpense(List<User> members) {
		this.members = members;
	}

	@Override
	public List<Split> getSplits(ExpenseRequest expense) {
		List<Split> splits = new ArrayList<>();
		double totalAmount = expense.getTotalAmount();
		double equalAmount = totalAmount / members.size();
		for (User member : members) {
			splits.add(new Split(member, equalAmount));
		}
		return splits;
	}
}