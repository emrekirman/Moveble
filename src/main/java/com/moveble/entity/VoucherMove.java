package com.moveble.entity;

import com.moveble.entity.base.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "voucher_move")
public class VoucherMove extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "measurement_unit_id")
    private MeasurementUnit measurementUnit;

    @Column(name = "quantity")
    @Positive(message = "Miktar 0'dan büyük olmalıdır.")
    private double quantity;

    @Column(name = "unit_price")
    @Positive(message = "Birim fiyat 0'dan büyük olmalıdır.")
    private double unitPrice;

    @Column(name = "amount")
    @Positive(message = "Tutar 0'dan büyük olmalıdır.")
    private double amount;

    @Column(name = "remaining_amount")
    @Positive(message = "Kalan miktar 0'dan büyük olmalıdır.")
    private double remainingAmount;

    @ManyToOne
    @JoinColumn(name = "voucher_id")
    private Voucher voucher;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "current_id")
    private Current current;

    @ManyToOne
    @JoinColumn(name = "product_descreption_id")
    private ProductDescription productDescription;


    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public ProductDescription getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(ProductDescription productDescription) {
        this.productDescription = productDescription;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }
}
