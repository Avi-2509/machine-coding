package com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.service;

import com.machine_coding.Machine.coding.practice.lldQuestions.splitwiseV2.model.User;

import java.util.Map;

public class ShowService {
    public void show(Map<String, Map<String, Double>> expenses){
        if(expenses == null){
            System.out.println("No Balances");
        }
        for(Map.Entry<String, Map<String, Double>> entry: expenses.entrySet()){
            if(!expenses.get(entry.getKey()).isEmpty()){
                System.out.println(entry.getKey() + " -> ");
            }
            for(Map.Entry<String, Double> mp: expenses.get(entry.getKey()).entrySet()){
                System.out.print(mp.getKey() + " -> " + mp.getValue() + "    ");
            }
            System.out.println();
        }
    }
}
