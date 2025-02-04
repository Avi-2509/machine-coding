package com.machine_coding.Machine.coding.practice.lldQuestions.springPlanner.services;

import com.machine_coding.Machine.coding.practice.lldQuestions.springPlanner.enums.TaskStatusEnum;
import com.machine_coding.Machine.coding.practice.lldQuestions.springPlanner.enums.TaskTypeEnum;
import com.machine_coding.Machine.coding.practice.lldQuestions.springPlanner.model.Task;

public class TaskService {

    public Task createTask(String taskDescription, TaskStatusEnum taskStatusEnum, TaskTypeEnum taskTypeEnum){
        Task task = new Task();
        task.setTaskType(taskTypeEnum);
        task.setTaskStatus(taskStatusEnum);
        task.setDescription(taskDescription);
        return task;
    }
}
