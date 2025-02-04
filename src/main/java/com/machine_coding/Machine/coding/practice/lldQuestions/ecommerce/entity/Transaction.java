package com.machine_coding.Machine.coding.practice.lldQuestions.ecommerce.entity;

import com.machine_coding.Machine.coding.practice.lldQuestions.ecommerce.enums.TransactionStatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction extends Base{
    private Double amount;
    private String orderId;
    private TransactionStatusEnum transactionStatus;
}
