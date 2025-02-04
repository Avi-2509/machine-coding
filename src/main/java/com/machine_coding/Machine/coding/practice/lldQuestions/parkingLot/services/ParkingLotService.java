package com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.services;

import com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.enums.VehicleTypeEnum;
import com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.model.Floor;
import com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.model.ParkingLot;
import com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.model.Slot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotService {
    public ParkingLot createParkingLot(final String id, final Integer numberOfFloors,
                                       final Integer numberOfSlotsInEachFloor){
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(id);
        parkingLot.setFloorList(new ArrayList<>());


        for(int i = 1; i <= numberOfFloors; i++){
            Floor floor = new Floor();
            floor.setNumber(i);
            floor.setTotalSlots(6);
            floor.setSlotList(new ArrayList<>());

            List<Slot> slotList = new ArrayList<>();
            for(int slotNumber = 1; slotNumber <= numberOfSlotsInEachFloor; slotNumber++){
                Slot slot = new Slot();
                slot.setNumber(slotNumber);
                slot.setIsOccupied(Boolean.FALSE);

                if(slotNumber == 1) slot.setVehicleType(VehicleTypeEnum.TRUCK);
                else if(slotNumber <= 3) slot.setVehicleType(VehicleTypeEnum.BIKE);
                else slot.setVehicleType(VehicleTypeEnum.CAR);
                slotList.add(slot);
            }
            floor.setSlotList(slotList);
            parkingLot.getFloorList().add(floor);
        }

        System.out.println("Created parking lot with " + numberOfFloors + " floors and " + numberOfSlotsInEachFloor +
                " slots per floor");
        return parkingLot;
    }
}
