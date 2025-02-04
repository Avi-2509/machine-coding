package com.machine_coding.Machine.coding.practice.lldQuestions.splitwise.services;

import com.machine_coding.Machine.coding.practice.lldQuestions.splitwise.enums.ExpenseTypeEnum;
import com.machine_coding.Machine.coding.practice.lldQuestions.splitwise.model.UserExpense;

import java.util.ArrayList;
import java.util.List;

public class UserExpenseDivisionService {
    public List<UserExpense> assignUserExpenses(final List<String> inputList, List<UserExpense> userExpenseList){
        String helperUserId = inputList.get(1);
        Double amount = Double.parseDouble(inputList.get(2));

        int numberOfOwners = Integer.parseInt(inputList.get(3));
        List<String> ownersUserIdList = new ArrayList<>();
        int idx = 4;
        while (numberOfOwners > 0){
            ownersUserIdList.add(inputList.get(idx));
            idx += 1;
            numberOfOwners -= 1;
        }

        ExpenseTypeEnum expenseTypeEnum = ExpenseTypeEnum.valueOf(inputList.get(idx));
        switch (expenseTypeEnum){
            case EQUAL:
                return equalDivide(ownersUserIdList, helperUserId, amount, userExpenseList);

            case EXACT:
                return exactDivide(ownersUserIdList, helperUserId, amount, idx + 1, inputList, userExpenseList);
                
            case PERCENT:
                return percentDivision(ownersUserIdList, helperUserId, amount, idx + 1, inputList, userExpenseList);

        }
        return null;
    }

    private List<UserExpense> percentDivision(List<String> ownersUserIdList, String helperUserId, Double amount, int idx, List<String> inputList, List<UserExpense> userExpenseList) {
        List<UserExpense> newUserExpenseList = new ArrayList<>();
        for(String userId: ownersUserIdList){
            Double calculatedAmount = amount * Double.parseDouble(inputList.get(idx++)) / 100;
            setUserExpenseList(userId, helperUserId, userExpenseList, calculatedAmount, newUserExpenseList);
        }
        userExpenseList.addAll(newUserExpenseList);
        return userExpenseList;
    }

    private List<UserExpense> equalDivide(List<String> userIdList, final String helperUserId, final Double amount,
                                          List<UserExpense> userExpenseList){
        Double dividedAmount = amount / userIdList.size();
        List<UserExpense> newUserExpenseList = new ArrayList<>();
        for(String userId: userIdList){
            setUserExpenseList(userId, helperUserId, userExpenseList, dividedAmount, newUserExpenseList);
        }
        userExpenseList.addAll(newUserExpenseList);
        return userExpenseList;
    }

    private List<UserExpense> exactDivide(List<String> userIdList, final String helperUserId, final Double amount,
                                          Integer idx, List<String> inputList,
                                          List<UserExpense> userExpenseList){
        List<UserExpense> newUserExpenseList = new ArrayList<>();
        for(String userId: userIdList){
            Double calculatedAmount = Double.parseDouble(inputList.get(idx++));
            setUserExpenseList(userId, helperUserId, userExpenseList, calculatedAmount, newUserExpenseList);
        }
        userExpenseList.addAll(newUserExpenseList);
        return userExpenseList;
    }

    private UserExpense getIfHelperIsOwnerUserExpense(final String helperUserId, final String ownerUserId, final List<UserExpense> userExpenseList){
        for (UserExpense userExpense: userExpenseList){
            if (userExpense.getHelperUserId().equals(ownerUserId) && userExpense.getOwnerUserId().equals(helperUserId)){
                return userExpense;
            }
        }
        return null;
    }

    private UserExpense checkIfAlreadyOwns(final String helperUserId, final String ownerUserId, final List<UserExpense> userExpenseList){
        for (UserExpense userExpense: userExpenseList){
            if (userExpense.getHelperUserId().equals(helperUserId) && userExpense.getOwnerUserId().equals(ownerUserId)){
                return userExpense;
            }
        }
        return null;
    }

    private void setUserExpenseList(String userId, String helperUserId, List<UserExpense> userExpenseList, Double calculatedAmount, List<UserExpense> newUserExpenseList){
        if(userId.equals(helperUserId)){
            return;
        }
        UserExpense alreadyPaymentExpense = checkIfAlreadyOwns(helperUserId, userId, userExpenseList);
        if(alreadyPaymentExpense != null){
            alreadyPaymentExpense.setAmount(alreadyPaymentExpense.getAmount() + calculatedAmount);
            userExpenseList.set(userExpenseList.indexOf(alreadyPaymentExpense), alreadyPaymentExpense);
            return;
        }

        UserExpense userExpense = new UserExpense();
        userExpense.setOwnerUserId(userId);
        userExpense.setHelperUserId(helperUserId);
        userExpense.setAmount(calculatedAmount);

        UserExpense oldUserExpense = getIfHelperIsOwnerUserExpense(helperUserId, userId, userExpenseList);
        if (oldUserExpense != null){
            if(oldUserExpense.getAmount() > userExpense.getAmount()){
                oldUserExpense.setAmount(userExpense.getAmount() - oldUserExpense.getAmount());
                return;
            }
            else if(oldUserExpense.getAmount() < userExpense.getAmount() ){
                userExpenseList.remove(oldUserExpense);
                userExpense.setAmount(userExpense.getAmount() - oldUserExpense.getAmount());
            }
        }
        newUserExpenseList.add(userExpense);
    }
}
