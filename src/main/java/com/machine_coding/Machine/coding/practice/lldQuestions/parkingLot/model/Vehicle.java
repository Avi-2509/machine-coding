package com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.model;

import com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.enums.VehicleTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle {
    private VehicleTypeEnum vehicleType;
    private String registrationNumber;
    private String color;
}
