package com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.service;


import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.model.Group;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupService {
	private final Map<String, Group> groups = new HashMap<>();

	public void addGroup(Group group) {
		groups.put(group.getGroupId(), group);
	}

	public void addGroupMember(String id, User user) {
		Group group = groups.get(id);
		group.getMembers().add(user);
		user.getGroups().add(group);
	}

	public List<User> getGroupMembers(String id) {
		return groups.get(id).getMembers();
	}
}
