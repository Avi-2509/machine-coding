package com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.service;

import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> userMap;

    public UserService(){
        userMap = new HashMap<>();
    }

    public void createUser(User user){
        userMap.put(user.getUserId(), user);
    }

    public User getUser(String id){
        return userMap.get(id);
    }
}
