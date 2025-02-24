package com.machine_coding.Machine.coding.practice.lldQuestions.splitwise.model;

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
    String groupId;
    List<User> userList;
}
