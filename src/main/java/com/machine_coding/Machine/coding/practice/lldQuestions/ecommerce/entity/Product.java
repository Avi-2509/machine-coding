package com.machine_coding.Machine.coding.practice.lldQuestions.ecommerce.entity;

import com.machine_coding.Machine.coding.practice.lldQuestions.ecommerce.enums.CategoryTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Product extends Base{
    private String name;
    private String description;
    private List<CategoryTypeEnum> category;
    private List<String> productImages;
    private Double price;
    private Integer maxOrderQtyCapping;
}
