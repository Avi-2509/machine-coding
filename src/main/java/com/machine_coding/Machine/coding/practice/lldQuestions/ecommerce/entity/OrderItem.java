package com.machine_coding.Machine.coding.practice.lldQuestions.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItem extends Base{
    private String orderId;
    private String sellerProductId;
    private Integer quantity;
}
