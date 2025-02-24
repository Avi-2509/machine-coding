package com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Group {
	private String groupId;
	private String groupName;
	private List<User> members;
}