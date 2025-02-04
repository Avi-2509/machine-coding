package com.machine_coding.Machine.coding.practice.lldQuestions.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SellerProduct extends Base{
    private String sellerId;
    private String productId;
    private Integer availableQuantity;
}
