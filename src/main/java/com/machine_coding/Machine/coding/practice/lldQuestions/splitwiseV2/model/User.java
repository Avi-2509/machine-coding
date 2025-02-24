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
public class User {
	private String userId;
	private String name;
	private List<Group> groups;
}
