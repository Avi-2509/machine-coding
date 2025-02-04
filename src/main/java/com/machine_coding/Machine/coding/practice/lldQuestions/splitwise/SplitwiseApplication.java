package com.machine_coding.Machine.coding.practice.lldQuestions.splitwise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwise.enums.InputTypeEnum;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwise.model.User;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwise.model.UserExpense;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwise.services.UserExpenseDivisionService;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwise.services.UserExpenseService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SplitwiseApplication {

	public static void main(String[] args) throws JsonProcessingException {

		Scanner scanner = new Scanner(System.in);
		List<User> userList = getUsers();
		List<UserExpense> userExpenseList = new ArrayList<>();

		UserExpenseService userExpenseService = new UserExpenseService();
		UserExpenseDivisionService userExpenseDivisionService = new UserExpenseDivisionService();


		while (true){
			String inputString = scanner.nextLine();
			List<String> inputList = Arrays.asList(inputString.split(" "));

			InputTypeEnum inputTypeEnum = InputTypeEnum.valueOf(inputList.get(0));

			switch (inputTypeEnum){
				case SHOW:
					if(inputList.size() > 1){
						userExpenseService.showUserBalanceByUserId(userExpenseList, userList, inputList.get(1));
						break;
					}
					userExpenseService.showAllUserBalance(userExpenseList, userList);
					break;

				case EXPENSE:
					userExpenseList = userExpenseDivisionService.assignUserExpenses(inputList, userExpenseList);
//					System.out.println(new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true).writeValueAsString(userExpenseList));
//					userExpenseService.showAllUserBalance(userExpenseList, userList);
					break;

				default:
					continue;
			}
		}

	}

	private static List<User> getUsers() {
		List<User> userList = new ArrayList<>();

		User user1 = new User();
		user1.setUserId("u1");
		user1.setName("Avi");
		user1.setEmail("avisrivastavaas1@gmail.com");
		user1.setMobileNumber("9900495003");

		User user2 = new User();
		user2.setUserId("u2");
		user2.setName("Aman");
		user2.setEmail("aman@gmail.com");
		user2.setMobileNumber("9950300302");

		User user3 = new User();
		user3.setUserId("u3");
		user3.setName("Anuj");
		user3.setEmail("anuj@gmail.com");
		user3.setMobileNumber("9400300302");

		User user4 = new User();
		user4.setUserId("u4");
		user4.setName("Anuj");
		user4.setEmail("anuj@gmail.com");
		user4.setMobileNumber("9400300302");

		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		return userList;
	}

}
