package com.machine_coding.Machine.coding.practice.lldQuestions.parkingLot.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Floor{
    private Integer number;
    private List<Slot> slotList;
    private Integer totalSlots;
}
