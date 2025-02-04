package com.machine_coding.Machine.coding.practice.designPatterns.strategyPattern;

import com.machine_coding.Machine.coding.practice.designPatterns.strategyPattern.concreteClass.Vehicle;
import com.machine_coding.Machine.coding.practice.designPatterns.strategyPattern.interfaces.ILookBehaviour;
import com.machine_coding.Machine.coding.practice.designPatterns.strategyPattern.interfaces.IMileageBehaviour;
import com.machine_coding.Machine.coding.practice.designPatterns.strategyPattern.interfaces.ISoundBehaviour;
import com.machine_coding.Machine.coding.practice.designPatterns.strategyPattern.interfaces.implementation.GoodMileageBehaviour;
import com.machine_coding.Machine.coding.practice.designPatterns.strategyPattern.interfaces.implementation.HighExhaustSoundBehaviour;
import com.machine_coding.Machine.coding.practice.designPatterns.strategyPattern.interfaces.implementation.NormalExhaustSoundBehaviour;
import com.machine_coding.Machine.coding.practice.designPatterns.strategyPattern.interfaces.implementation.SportyLookBehaviour;

public class StrategyPatternApp {
    public static void main(String[] args) {

        IMileageBehaviour iMileageBehaviour = new GoodMileageBehaviour();
        ILookBehaviour iLookBehaviour = new SportyLookBehaviour();
        ISoundBehaviour iSoundBehaviour = new HighExhaustSoundBehaviour();
        Vehicle vehicle = new Vehicle(iLookBehaviour, iMileageBehaviour, iSoundBehaviour);
        vehicle.getBehaviours();
    }
}
