package com.machine_coding.Machine.coding.practice.designPatterns.strategyPattern.interfaces.implementation;

import com.machine_coding.Machine.coding.practice.designPatterns.strategyPattern.interfaces.ISoundBehaviour;

public class NormalExhaustSoundBehaviour implements ISoundBehaviour {
    @Override
    public void showSoundLevel() {
        System.out.println("NormalExhaustSoundBehaviour");
    }
}
