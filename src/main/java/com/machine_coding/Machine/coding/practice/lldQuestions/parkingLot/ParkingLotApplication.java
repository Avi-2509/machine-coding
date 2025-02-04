package com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.enums.VehicleTypeEnum;
import com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.model.*;
import com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.services.ParkingLotService;
import com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.services.SlotService;
import com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.services.inter.IParkingAllotmentService;

import java.util.List;
import java.util.Scanner;

public class ParkingLotApplication {

	public static void main(String[] args) throws JsonProcessingException {

		Scanner scanner = new Scanner(System.in);
		ParkingLotService parkingLotService = new ParkingLotService();
		ParkingLot parkingLot = null;

		SlotService slotService = new SlotService();
		IParkingAllotmentServiceFactory iParkingAllotmentServiceFactory = new IParkingAllotmentServiceFactory();
		IParkingAllotmentService parkingAllotmentService = iParkingAllotmentServiceFactory.getIParkingAllotmentService("Generic");

		while(true){
			String input = scanner.nextLine();
			List<String> inputlist = List.of(input.split(" "));

			String command = inputlist.get(0);

			switch (command){
				case "create_parking_lot" :
					parkingLot = parkingLotService.createParkingLot(inputlist.get(1), Integer.parseInt(inputlist.get(2)),
							Integer.parseInt(inputlist.get(3)));
//					System.out.println(new ObjectMapper().writeValueAsString(parkingLot));
					break;

				case "display" :
					String displayType = inputlist.get(1);
					switch (displayType){
						case "free_count":
							slotService.getFreeSlotsCount(parkingLot, VehicleTypeEnum.valueOf(inputlist.get(2)));
							break;

						case "free_slots":
							slotService.getFreeSlots(parkingLot, VehicleTypeEnum.valueOf(inputlist.get(2)));
							break;

						case "occupied_slots":
							slotService.getOccupiedSlots(parkingLot, VehicleTypeEnum.valueOf(inputlist.get(2)));
							break;
					}
					break;


				case "park_vehicle":
					Vehicle vehicle1 = new Vehicle();
					vehicle1.setVehicleType(VehicleTypeEnum.valueOf(inputlist.get(1)));
					vehicle1.setColor(inputlist.get(3));
					vehicle1.setRegistrationNumber(inputlist.get(2));

					Ticket ticket = parkingAllotmentService.park(parkingLot, vehicle1);
					if(ticket == null){
						System.out.println("Parking Lot Full");
					}
					break;

				case "unpark_vehicle":
					String ticketId = inputlist.get(1);
					Boolean isUnparkValidAndDone = parkingAllotmentService.unPark(parkingLot, ticketId);
					if(!isUnparkValidAndDone){
						System.out.println("Invalid Ticket");
					}
					break;

			}
		}

	}

}
