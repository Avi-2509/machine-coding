package com.machine_coding.Machine.coding.practice.lldQuestions.springPlanner.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {
    private String id;
    private List<Task> taskList;
}
