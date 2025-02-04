package com.machine_coding.Machine.coding.practice.lldQuestions.ecommerce.entity;

import com.machine_coding.Machine.coding.practice.lldQuestions.ecommerce.enums.CatalogStatusEnum;
import com.machine_coding.Machine.coding.practice.lldQuestions.ecommerce.enums.CategoryTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Catalog extends Base{
    List<String> productIdList;
    private CategoryTypeEnum categoryTypeEnum;
    private CatalogStatusEnum catalogStatusEnum;
    private Integer ranking;
}
