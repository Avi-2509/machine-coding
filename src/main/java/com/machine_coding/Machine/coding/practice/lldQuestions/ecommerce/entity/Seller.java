package com.machine_coding.Machine.coding.practice.lldQuestions.ecommerce.entity;

import com.machine_coding.Machine.coding.practice.lldQuestions.ecommerce.enums.NodeStatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Seller extends Base{
    private String address;
    private List<String> offeringPincodeList;
    private String wareHouseName;
    private NodeStatusEnum nodeStatus;
}
