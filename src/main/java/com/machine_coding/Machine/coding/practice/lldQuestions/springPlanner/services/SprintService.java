package com.machine_coding.Machine.coding.practice.lldQuestions.springPlanner.services;

import com.machine_coding.Machine.coding.practice.lldQuestions.springPlanner.model.Sprint;
import com.machine_coding.Machine.coding.practice.lldQuestions.springPlanner.model.Task;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class SprintService {
    public Sprint createSprint(Date startDate, Date endDate){
        Sprint sprint = new Sprint();
        sprint.setId(UUID.randomUUID().toString());
        sprint.setStartDate(startDate);
        sprint.setEndDate(endDate);
        sprint.setTaskList(new ArrayList<>());
        return sprint;
    }

    public Sprint addTask(Sprint sprint, Task task){
        if(sprint.getTaskList().size() > 20){
            System.out.println("not allowed to add task");
            return sprint;
        }

        sprint.getTaskList().add(task);
        return sprint;
    }
}
