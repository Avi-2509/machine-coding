package com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.model;

import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.enums.SplitType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Expense {
	private String expenseId;
	private Date createdOn;
	private String description;
	private double totalAmount;
	private User paidBy;
	private SplitType splitType;
	private List<Split> splitBetween;
}