package com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.model.*;
import com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.services.inter.IParkingAllotmentService;
import org.apache.commons.lang3.time.DateUtils;

import java.util.*;

public class ParkingAllotmentServiceImpl implements IParkingAllotmentService {

    public Ticket park(ParkingLot parkingLot, Vehicle vehicle){
        List<Floor> floorList = parkingLot.getFloorList();

        Comparator<Floor> comp = (Floor a1, Floor a2) -> a1.getNumber().compareTo(a2.getNumber());
        Collections.sort(floorList, comp);

        for(Floor floor: floorList){
            List<Slot> slotList = floor.getSlotList();
            Comparator<Slot> com2 = (Slot a1, Slot a2) -> a1.getNumber().compareTo(a2.getNumber());
            Collections.sort(slotList, com2);

            for(Slot slot: slotList){
                if(!slot.getIsOccupied() && vehicle.getVehicleType().equals(slot.getVehicleType())){
                    //create ticket
                    Ticket ticket = new Ticket();
                    slot.setIsOccupied(Boolean.TRUE);
                    slot.setVehicle(vehicle);

                    ticket.setId(parkingLot.getId() + "_" + floor.getNumber() + "_" + slot.getNumber());
                    System.out.println("Parked vehicle. Ticket ID: " + ticket.getId());
                    return ticket;
                }
            }
        }
        return null;


    }

    @Override
    public Boolean unPark(ParkingLot parkingLot, String ticketId) {
        List<String> parkingTicketDetails = Arrays.asList(ticketId.split("_"));
        if(!parkingTicketDetails.get(0).equals(parkingLot.getId())){
            return false;
        }
        Integer floorNumber = Integer.parseInt(parkingTicketDetails.get(1));
        Integer slotNumber = Integer.parseInt(parkingTicketDetails.get(2));

        if(floorNumber > parkingLot.getFloorList().size()){
            return false;
        }

        Floor floor = parkingLot.getFloorList().get(floorNumber - 1);

        if(slotNumber > floor.getSlotList().size()){
            return false;
        }
        Slot slot = floor.getSlotList().get(slotNumber - 1);
        if(!slot.getIsOccupied()){
            return false;
        }
        System.out.println("Unparked vehicle with Registration Number: " + slot.getVehicle().getRegistrationNumber() +
                 " and Color: " + slot.getVehicle().getColor());

        slot.setIsOccupied(Boolean.FALSE);
        slot.setVehicle(null);
        return true;
    }
}
