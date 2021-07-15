package com.moveble.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moveble.entity.base.BaseEntity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "voucher")
@Data
public class Voucher extends BaseEntity {

    @Column(name = "no")
    private int no;

    @Column(name = "date")
    @NotNull(message = "Tarih alanı boş geçilemez")
    @NotBlank(message = "Tarih alanı boş geçilemez")
    private Date date;

    @Column(name = "document_rest")
    @NotNull(message = "Dayanak belge alanı boş geçilemez")
    @NotBlank(message = "Dayanak belge alanı boş geçilemez")
    private String documentRest;

    @Column(name = "rest_date")
    @NotNull(message = "Dayanak Tarih alanı boş geçilemez")
    @NotBlank(message = "Dayanak Tarih alanı boş geçilemez")
    private Date restDate;

    @Column(name = "description")
    @NotNull(message = "Açıklama alanı boş geçilemez")
    @NotBlank(message = "Açıklama alanı boş geçilemez")
    private String description;

    @Column(name = "rest_no")
    @NotNull(message = "Dayanak no alanı boş geçilemez")
    @NotBlank(message = "Dayanak no alanı boş geçilemez")
    private String restNo;

    @Column(name = "movement_type")
    @Positive(message = "Hareket tipi giriş veya çıkış olmalıdır.")
    private int movementType;

    @ManyToOne
    @JoinColumn(name = "current_id")
    @JsonProperty("current")
    private Current current;

    @ManyToOne
    @JoinColumn(name = "transaction_type_id")
    @JsonProperty("transactionTypeId")
    private TransactionType transactionType;

    @OneToMany(mappedBy = "voucher")
    @JsonProperty("voucherMoveList")
    private List<VoucherMove> voucherMoveList;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    @JsonProperty("unit")
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "measurement_unit_id")
    @JsonProperty("measurementUnit")
    private MeasurementUnit measurementUnit;

}
