package com.machine_coding.Machine.coding.practice.designPatterns.strategyPattern.interfaces.implementation;

import com.machine_coding.Machine.coding.practice.designPatterns.strategyPattern.interfaces.ISoundBehaviour;

public class HighExhaustSoundBehaviour implements ISoundBehaviour {
    @Override
    public void showSoundLevel() {
        System.out.println("HighExhaustSoundBehaviour");
    }
}
