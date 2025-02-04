package com.machine_coding.Machine.coding.practice.designPatterns.strategyPattern.interfaces.implementation;

import com.machine_coding.Machine.coding.practice.designPatterns.strategyPattern.interfaces.IMileageBehaviour;

public class LowMileageBehaviour implements IMileageBehaviour {
    @Override
    public void showMileage() {
        System.out.println("LowMileageBehaviour");
    }
}
