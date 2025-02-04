package com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.services.inter;

import com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.model.ParkingLot;
import com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.model.Ticket;
import com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.model.Vehicle;

public interface IParkingAllotmentService {
    public Ticket park(ParkingLot parkingLot, Vehicle vehicle);
    public Boolean unPark(ParkingLot parkingLot, String ticketId);
}
