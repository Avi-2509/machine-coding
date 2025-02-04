package com.machine_coding.Machine.coding.practice.lldQuestions.ecommerce.entity;

import com.machine_coding.Machine.coding.practice.lldQuestions.ecommerce.enums.OrderStatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Order extends Base{
    private String userId;
    private OrderStatusEnum orderStatus;
    private List<OrderItem> orderItemList;
    private Double totalPrice;
    private String transactionId;
}
