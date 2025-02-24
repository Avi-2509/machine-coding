package com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.service;

import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.model.ExpenseRequest;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.model.User;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.service.impl.EqualExpense;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.service.impl.ExactExpense;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.service.impl.PercentageExpense;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseFactory {
	public static ExpenseService getExpenseService(ExpenseRequest request, List<User> members) {
		switch (request.getSplitType()) {
			case EXACT:
				Map<String, Double> exactSplits = new HashMap<>();
				for (Map.Entry<User, Double> entry : request.getSplits().entrySet()) {
					exactSplits.put(entry.getKey().getUserId(), entry.getValue());
				}
				return new ExactExpense(members, exactSplits);
			case EQUAL:
				return new EqualExpense(members);
			case PERCENT:
				Map<String, Double> percentSplits = new HashMap<>();
				for (Map.Entry<User, Double> entry : request.getSplits().entrySet()) {
					percentSplits.put(entry.getKey().getUserId(), entry.getValue());
				}
				return new PercentageExpense(members, percentSplits);
			default:
				throw new IllegalArgumentException("Invalid SplitType");
		}
	}
}