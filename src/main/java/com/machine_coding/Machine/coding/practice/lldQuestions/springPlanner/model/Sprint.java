package com.machine_coding.Machine.coding.practice.lldQuestions.springPlanner.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Sprint {
    private String id;
    private Date startDate;
    private Date endDate;
    private List<Task> taskList;
}
