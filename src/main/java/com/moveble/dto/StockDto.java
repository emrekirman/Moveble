package com.moveble.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDto {

    private double quantity;

    private String unitName;

    private int unitId;

    private String productDescriptionName;

    private int productDescriptionId;

    private int movementType;

}
