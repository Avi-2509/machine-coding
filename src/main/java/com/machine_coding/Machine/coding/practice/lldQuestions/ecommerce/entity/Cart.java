package com.machine_coding.Machine.coding.practice.lldQuestions.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Cart extends Base{
    private String userId;
    private Double totalPrice;
    private List<CartItem> cartItemList;
}
