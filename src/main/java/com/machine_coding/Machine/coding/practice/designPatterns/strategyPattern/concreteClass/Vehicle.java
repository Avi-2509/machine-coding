package com.machine_coding.Machine.coding.practice.designPatterns.strategyPattern.concreteClass;

import com.machine_coding.Machine.coding.practice.designPatterns.strategyPattern.interfaces.ILookBehaviour;
import com.machine_coding.Machine.coding.practice.designPatterns.strategyPattern.interfaces.IMileageBehaviour;
import com.machine_coding.Machine.coding.practice.designPatterns.strategyPattern.interfaces.ISoundBehaviour;

public class Vehicle {
    ILookBehaviour iLookBehaviour;
    IMileageBehaviour iMileageBehaviour;
    ISoundBehaviour iSoundBehaviour;
    public Vehicle(ILookBehaviour iLookBehaviour, IMileageBehaviour iMileageBehaviour, ISoundBehaviour iSoundBehaviour){
        this.iLookBehaviour = iLookBehaviour;
        this.iMileageBehaviour = iMileageBehaviour;
        this.iSoundBehaviour = iSoundBehaviour;
    }

    public void getBehaviours(){
        this.iLookBehaviour.showLook();
        this.iSoundBehaviour.showSoundLevel();
        this.iMileageBehaviour.showMileage();
    }
}
