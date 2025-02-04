package com.machine_coding.Machine.coding.practice.lldQuestions.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItem extends Base{
    private String cartId;
    private String sellerProductId;
    private Integer quantity;
    private Double totalCartItemPrice;
}
