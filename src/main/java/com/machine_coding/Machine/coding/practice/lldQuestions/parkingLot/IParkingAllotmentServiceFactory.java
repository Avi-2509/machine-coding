package com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot;

import com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.services.ParkingAllotmentServiceImpl;
import com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.services.inter.IParkingAllotmentService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IParkingAllotmentServiceFactory {

    private final Map<String, IParkingAllotmentService> hashMap = new HashMap<>();


    public IParkingAllotmentServiceFactory() {
        System.out.println("called initiate");
        hashMap.put("Generic", new ParkingAllotmentServiceImpl());
    }

    public IParkingAllotmentService getIParkingAllotmentService(final String key) {
        return hashMap.get(key);
    }
}
