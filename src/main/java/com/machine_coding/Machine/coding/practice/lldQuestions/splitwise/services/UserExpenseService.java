package com.machine_coding.Machine.coding.practice.lldQuestions.splitwise.services;

import com.machine_coding.Machine.coding.practice.lldQuestions.splitwise.model.User;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwise.model.UserExpense;

import java.util.List;

public class UserExpenseService {

    public void showAllUserBalance(List<UserExpense> userExpenseList, List<User> users) {
        if (userExpenseList.isEmpty()) {
            System.out.println("No balances");
        }

        for (UserExpense userExpense : userExpenseList) {
            User userX = getUserById(users, userExpense.getOwnerUserId());
            User userY = getUserById(users, userExpense.getHelperUserId());
            if (userX == null || userY == null){
                continue;
            }
            System.out.println(userExpense.getOwnerUserId() + " owes " + userExpense.getHelperUserId() + ": " +
                    userExpense.getAmount());
        }
    }

    public void showUserBalanceByUserId(List<UserExpense> userExpenseList, List<User> users, final String userId) {
        if (userExpenseList.isEmpty()) {
            System.out.println("No balances");
        }

        for (UserExpense userExpense : userExpenseList) {
            if (!userExpense.getOwnerUserId().isEmpty() && userExpense.getOwnerUserId().equals(userId)) {
                User userX = getUserById(users, userExpense.getOwnerUserId());
                User userY = getUserById(users, userExpense.getHelperUserId());
                if (userX == null || userY == null) {
                    continue;
                }
                System.out.println(userExpense.getOwnerUserId() + " owes " + userExpense.getHelperUserId() + ": " +
                        userExpense.getAmount());
            }
        }
        for (UserExpense userExpense : userExpenseList) {
            if (!userExpense.getOwnerUserId().isEmpty() && userExpense.getHelperUserId().equals(userId)) {
                User userX = getUserById(users, userExpense.getOwnerUserId());
                User userY = getUserById(users, userExpense.getHelperUserId());
                if (userX == null || userY == null) {
                    continue;
                }
                System.out.println(userExpense.getOwnerUserId() + " owes " + userExpense.getHelperUserId() + ": " +
                        userExpense.getAmount());
            }
        }
    }

    private User getUserById(final List<User> users, final String userId) {
        for (User user : users) {
            if (userId.equals(user.getUserId())) {
                return user;
            }
        }
        return null;
    }
}
