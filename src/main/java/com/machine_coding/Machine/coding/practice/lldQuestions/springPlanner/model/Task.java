package com.machine_coding.Machine.coding.practice.lldQuestions.springPlanner.model;

import com.machine_coding.Machine.coding.practice.lldQuestions.springPlanner.enums.TaskStatusEnum;
import com.machine_coding.Machine.coding.practice.lldQuestions.springPlanner.enums.TaskTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Task {
    private String id;
    private String description;
    private TaskTypeEnum taskType;
    private TaskStatusEnum taskStatus;
}
