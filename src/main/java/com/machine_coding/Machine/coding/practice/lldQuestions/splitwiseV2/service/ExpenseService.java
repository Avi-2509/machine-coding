package com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.service;

import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.model.Expense;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.model.ExpenseRequest;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.model.Split;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ExpenseService {
	private static final Map<String, Map<String, Double>> expenses = new HashMap<>();

	public abstract List<Split> getSplits(ExpenseRequest expense);

	public Map<String, Map<String, Double>> getExpense() {
		return expenses;
	}

	public void saveExpense(Expense expense) {
		for (Split splitPerson : expense.getSplitBetween()) {
			User borrower = splitPerson.getUser();
			double amount = splitPerson.getAmount();
			if(borrower.getUserId().equals(expense.getPaidBy().getUserId())){
				continue;
			}
			addExpense(expense.getPaidBy(), borrower, amount);
		}
	}

	private void addExpense(User payer, User borrower, double amount) {
//		System.out.println(payer.getUserId());
		expenses.putIfAbsent(payer.getUserId(), new HashMap<>());
		Map<String, Double> payerBalanceSheet = expenses.get(payer.getUserId());

		payerBalanceSheet.putIfAbsent(borrower.getUserId(), 0.0);
		payerBalanceSheet.put(borrower.getUserId(), payerBalanceSheet.get(borrower.getUserId()) + amount);

		expenses.putIfAbsent(borrower.getUserId(), new HashMap<>());
		Map<String, Double> borrowerBalanceSheet = expenses.get(borrower.getUserId());

		borrowerBalanceSheet.putIfAbsent(payer.getUserId(), 0.0);
		borrowerBalanceSheet.put(payer.getUserId(), borrowerBalanceSheet.get(payer.getUserId()) - amount);
	}


}