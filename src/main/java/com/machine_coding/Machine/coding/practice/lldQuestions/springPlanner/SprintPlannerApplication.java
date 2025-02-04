package com.machine_coding.Machine.coding.practice.lldQuestions.springPlanner;

import com.machine_coding.Machine.coding.practice.lldQuestions.springPlanner.enums.TaskStatusEnum;
import com.machine_coding.Machine.coding.practice.lldQuestions.springPlanner.enums.TaskTypeEnum;
import com.machine_coding.Machine.coding.practice.lldQuestions.springPlanner.model.Sprint;
import com.machine_coding.Machine.coding.practice.lldQuestions.springPlanner.model.Task;
import com.machine_coding.Machine.coding.practice.lldQuestions.springPlanner.services.SprintService;
import com.machine_coding.Machine.coding.practice.lldQuestions.springPlanner.services.TaskService;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SprintPlannerApplication {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Sprint sprint = null;
		SprintService sprintService = new SprintService();
		TaskService taskService = new TaskService();

		while (true){
			String inputString = scanner.nextLine();
			List<String> inputList = Arrays.asList(inputString.split(" "));

			switch (inputList.get(0)){
				case "createSprint":
					Date startDate = new Date();
					Date endDate = new Date();
					sprint = sprintService.createSprint(startDate, endDate);
					break;

				case "createTask":
					Task task = taskService.createTask("test 1", TaskStatusEnum.TODO,
							TaskTypeEnum.FEATURE);
					sprint = sprintService.addTask(sprint, task);
			}
		}
	}

}
