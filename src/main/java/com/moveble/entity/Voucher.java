package com.moveble.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moveble.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "voucher")
public class Voucher extends BaseEntity {

    @Column(name = "no")
    private int no;

    @Column(name = "date")
    private Date date;

    @Column(name = "document_rest")
    private String documentRest;

    @Column(name = "rest_date")
    private Date restDate;

    @Column(name = "description")
    private String description;

    @Column(name = "rest_no")
    private String restNo;

    @Column(name = "movement_type")
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

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDocumentRest() {
        return documentRest;
    }

    public void setDocumentRest(String documentRest) {
        this.documentRest = documentRest;
    }

    public Date getRestDate() {
        return restDate;
    }

    public void setRestDate(Date restDate) {
        this.restDate = restDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRestNo() {
        return restNo;
    }

    public void setRestNo(String restNo) {
        this.restNo = restNo;
    }

    public int getMovementType() {
        return movementType;
    }

    public void setMovementType(int movementType) {
        this.movementType = movementType;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public List<VoucherMove> getVoucherMoveList() {
        return voucherMoveList;
    }

    public void setVoucherMoveList(List<VoucherMove> voucherMoveList) {
        this.voucherMoveList = voucherMoveList;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }
}
