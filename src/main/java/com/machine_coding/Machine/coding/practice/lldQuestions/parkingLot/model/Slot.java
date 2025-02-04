package com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.model;

import com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.enums.VehicleTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Slot{
    Integer number;
    Boolean isOccupied;
    Vehicle vehicle;
    VehicleTypeEnum vehicleType;
}
