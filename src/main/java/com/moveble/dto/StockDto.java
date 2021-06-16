package com.moveble.dto;

public class StockDto {

    public StockDto(double quantity, String unitName, int unitId,
                    String productDescriptionName, int productDescriptionId,
                    int movementType) {
        this.quantity = quantity;
        this.unitName = unitName;
        this.unitId = unitId;
        this.productDescriptionName = productDescriptionName;
        this.productDescriptionId = productDescriptionId;
        this.movementType = movementType;
    }

    public StockDto() {
    }

    private double quantity;

    private String unitName;

    private int unitId;

    private String productDescriptionName;

    private int productDescriptionId;

    private int movementType;

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getProductDescriptionName() {
        return productDescriptionName;
    }

    public void setProductDescriptionName(String productDescriptionName) {
        this.productDescriptionName = productDescriptionName;
    }

    public int getProductDescriptionId() {
        return productDescriptionId;
    }

    public void setProductDescriptionId(int productDescriptionId) {
        this.productDescriptionId = productDescriptionId;
    }

    public int getMovementType() {
        return movementType;
    }

    public void setMovementType(int movementType) {
        this.movementType = movementType;
    }
}
