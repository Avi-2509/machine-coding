package com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.model;

import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.enums.SplitType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseRequest {
	private User paidBy;
	private String groupId;
	private double totalAmount;
	private Map<User, Double> splits;
	private SplitType splitType;
	private String description;
}