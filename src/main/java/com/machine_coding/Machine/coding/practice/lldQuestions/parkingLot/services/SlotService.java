package com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.services;

import com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.enums.VehicleTypeEnum;
import com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.model.Floor;
import com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.model.ParkingLot;
import com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.model.Slot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SlotService {

    public void getFreeSlots(ParkingLot parkingLot, VehicleTypeEnum vehicleTypeEnum) {
        List<Floor> floorList = parkingLot.getFloorList();

        Comparator<Floor> comp = (Floor a1, Floor a2) -> a1.getNumber().compareTo(a2.getNumber());
        Collections.sort(floorList, comp);

        for (Floor floor : floorList) {
            List<Slot> slotList = floor.getSlotList();
            Comparator<Slot> com2 = (Slot a1, Slot a2) -> a1.getNumber().compareTo(a2.getNumber());
            Collections.sort(slotList, com2);

            List<Slot> freeSlot = new ArrayList<>();
            for (Slot slot : slotList) {
                if (!slot.getIsOccupied() && vehicleTypeEnum.equals(slot.getVehicleType())) {
                    freeSlot.add(slot);
                }
            }
            String freeSlotString = "";
            if (!freeSlot.isEmpty()) {
                freeSlotString = freeSlot.stream()
                        .map(slot -> slot.getNumber().toString())  // Convert slot number to String
                        .collect(Collectors.joining(", "));
            }
            System.out.println("Free slots for " + vehicleTypeEnum.name() + " on Floor " +
                    floor.getNumber() + " : " + freeSlotString);
        }
    }

    public void getFreeSlotsCount(ParkingLot parkingLot, VehicleTypeEnum vehicleTypeEnum) {
        List<Floor> floorList = parkingLot.getFloorList();

        Comparator<Floor> comp = (Floor a1, Floor a2) -> a1.getNumber().compareTo(a2.getNumber());
        Collections.sort(floorList, comp);

        for (Floor floor : floorList) {
            List<Slot> slotList = floor.getSlotList();
            Comparator<Slot> com2 = (Slot a1, Slot a2) -> a1.getNumber().compareTo(a2.getNumber());
            Collections.sort(slotList, com2);

            Integer freeSlotCount = 0;
            for (Slot slot : slotList) {
                if (!slot.getIsOccupied() && vehicleTypeEnum.equals(slot.getVehicleType())) {
                    freeSlotCount += 1;
                }
            }
            System.out.println("No. of free slots for " + vehicleTypeEnum.name() + " on Floor " +
                    floor.getNumber() + " : " + freeSlotCount);

        }
    }

    public void getOccupiedSlots(ParkingLot parkingLot, VehicleTypeEnum vehicleTypeEnum) {
        List<Floor> floorList = parkingLot.getFloorList();

        Comparator<Floor> comp = (Floor a1, Floor a2) -> a1.getNumber().compareTo(a2.getNumber());
        Collections.sort(floorList, comp);

        for (Floor floor : floorList) {
            List<Slot> slotList = floor.getSlotList();
            Comparator<Slot> com2 = (Slot a1, Slot a2) -> a1.getNumber().compareTo(a2.getNumber());
            Collections.sort(slotList, com2);

            List<Slot> occupiedSlots = new ArrayList<>();
            for (Slot slot : slotList) {
                if (slot.getIsOccupied() && vehicleTypeEnum.equals(slot.getVehicleType())) {
                    occupiedSlots.add(slot);
                }
            }
            String occupiedSlotString = "";
            if (!occupiedSlots.isEmpty()) {
                occupiedSlotString = occupiedSlots.stream()
                        .map(slot -> slot.getNumber().toString())  // Convert slot number to String
                        .collect(Collectors.joining(", "));
            }
            System.out.println("Occupied slots for " + vehicleTypeEnum.name() + " on Floor " +
                    floor.getNumber() + " : " + occupiedSlotString);
        }
    }


}
