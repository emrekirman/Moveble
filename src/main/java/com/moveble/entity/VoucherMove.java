package com.moveble.entity;

import com.moveble.entity.base.BaseEntity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "voucher_move")
@Data
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

}
