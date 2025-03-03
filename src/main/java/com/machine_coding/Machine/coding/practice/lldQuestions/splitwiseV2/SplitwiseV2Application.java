package com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.enums.CommandTypeEnum;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.enums.SplitType;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.model.*;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.service.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SplitwiseV2Application {

	static GroupService groupService = new GroupService();
	static UserService userService = new UserService();

	static ShowService showService = new ShowService();


	public static void main(String[] args) throws JsonProcessingException {

		Map<String, Map<String, Double>> expenseMap = new HashMap<>();
		createUser();
		String filePath = "/Users/avisrivastava/Desktop/Personal/Machine-coding-practice/src/main/java/com/machine_coding/Machine/coding/practice/lldQuestions/splitwiseV2/input.txt";

		try {
			Scanner scanner = new Scanner(new File(filePath));

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				List<String> inputList = Arrays.asList(line.split(" "));
				System.out.println(inputList);
				CommandTypeEnum commandTypeEnum = CommandTypeEnum.valueOf(inputList.get(0));
				switch (commandTypeEnum){
					case SHOW :
						if(expenseMap.isEmpty()){
							System.out.println("No balances");
						}
						else {
							showService.show(expenseMap);
						}
						break;

					case EXPENSE:
						request(expenseMap, inputList);
						break;
				}
//				System.out.println(line);
			}

			// Close the scanner
			scanner.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + filePath);
			e.printStackTrace();
		}





//		request2(u1, u2, u3, expenseService);
	}

	public static void request(Map<String, Map<String, Double>> expenseMap, List<String> stringInputList){

		User paidByUser = userService.getUser(stringInputList.get(1));

		ExpenseRequest request = new ExpenseRequest();
		request.setDescription("tmp");
		request.setTotalAmount(Double.valueOf(stringInputList.get(2)));
		request.setPaidBy(paidByUser);
		request.setGroupId("123");
		request.setSplits(new HashMap<>());
		int idx = 4;

		SplitType splitType = SplitType.valueOf(stringInputList.get(idx + Integer.valueOf(stringInputList.get(3))));
		request.setSplitType(splitType);
		Integer numberOfUser = Integer.valueOf(stringInputList.get(3));
		for(int i = 0; i < numberOfUser; i++){
			if(splitType.equals(SplitType.EQUAL)){
				request.getSplits().put(userService.getUser(stringInputList.get(idx)), 0.00);
			} else if (splitType.equals(SplitType.EXACT)) {
				request.getSplits().put(userService.getUser(stringInputList.get(idx)), Double.valueOf(stringInputList.get(idx + numberOfUser + 1)));
			}
			else {
				request.getSplits().put(userService.getUser(stringInputList.get(idx)), Double.valueOf(stringInputList.get(idx + numberOfUser + 1)));
			}
			idx += 1;
		}

//		System.out.println(request);
		List<User> members = new ArrayList<>();
		members.addAll(request.getSplits().keySet());
		if (request.getGroupId() != "") members = groupService.getGroupMembers(request.getGroupId());

		ExpenseService expenseService = ExpenseFactory.getExpenseService(request, members);
		List<Split> splitDetails = expenseService.getSplits(request);

		Expense expense = new Expense();
		expense.setCreatedOn(new Date());
		expense.setDescription(request.getDescription());
		expense.setPaidBy(request.getPaidBy());
		expense.setSplitBetween(splitDetails);
		expense.setSplitType(request.getSplitType());
		expense.setTotalAmount(request.getTotalAmount());
		expenseService.saveExpense(expense);
		expenseMap = expenseService.getExpense();
		showService.show(expenseService.getExpense());
	}

	public static void request2(User u1, User u2, User u3, ExpenseService expenseService1){
//		expenseService.showExpenses();
		ExpenseRequest request = new ExpenseRequest();
		request.setDescription("tmp");
		request.setTotalAmount(1000);
		request.setSplitType(SplitType.EXACT);
		request.setPaidBy(u2);
		request.setGroupId("123");
		request.setSplits(new HashMap<>());
		request.getSplits().put(u1, 800.00);
		request.getSplits().put(u3, 100.00);

		System.out.println(request);
		List<User> members = new ArrayList<>();
		members.addAll(request.getSplits().keySet());
		if (request.getGroupId() != "") members = groupService.getGroupMembers(request.getGroupId());

		ExpenseService expenseService = ExpenseFactory.getExpenseService(request, new ArrayList<>(request.getSplits().keySet()));
		List<Split> splitDetails = expenseService.getSplits(request);

		Expense expense = new Expense();
		expense.setCreatedOn(new Date());
		expense.setDescription(request.getDescription());
		expense.setPaidBy(request.getPaidBy());
		expense.setSplitBetween(splitDetails);
		expense.setSplitType(request.getSplitType());
		expense.setTotalAmount(request.getTotalAmount());
		expenseService.saveExpense(expense);
		showService.show(expenseService.getExpense());
	}

	public static void createUser(){
		User u1 = new User();
		u1.setName("Avi");
		u1.setUserId("u1");
		u1.setGroups(new ArrayList<>());
		userService.createUser(u1);

		User u2 = new User();
		u2.setName("alexander");
		u2.setUserId("u2");
		u2.setGroups(new ArrayList<>());
		userService.createUser(u2);

		User u3 = new User();
		u3.setName("namibia");
		u3.setUserId("u3");
		u3.setGroups(new ArrayList<>());
		userService.createUser(u3);

		User u4 = new User();
		u4.setName("namibia");
		u4.setUserId("u4");
		u4.setGroups(new ArrayList<>());
		userService.createUser(u4);


		Group group =  new Group();
		group.setGroupName("3idiots");
		group.setGroupId("123");
		group.setMembers(new ArrayList<>());
		groupService.addGroup(group);

		groupService.addGroupMember("123", u1);
		groupService.addGroupMember("123", u2);
		groupService.addGroupMember("123", u3);
		groupService.addGroupMember("123", u4);

	}
}