package com.moveble.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoucherMoveDto {

    private int id;

    private double unitPrice;

    private double quantity;

    private double amount;

    private int movementType;

    private String unitName;

    private int unitId;

    private String productDescriptionName;

    private int productDescriptionId;
}
