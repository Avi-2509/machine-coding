package com.machine_coding.Machine.coding.practice.designPatterns.strategyPattern.interfaces.implementation;

import com.machine_coding.Machine.coding.practice.designPatterns.strategyPattern.interfaces.ILookBehaviour;

public class SedanLookBehaviour implements ILookBehaviour {
    @Override
    public void showLook() {
        System.out.println("SedanLookBehaviour");
    }
}
