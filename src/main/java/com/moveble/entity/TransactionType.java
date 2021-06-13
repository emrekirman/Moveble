package com.moveble.entity;

import com.moveble.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "transaction_type")
public class TransactionType extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "transactionType")
    private List<Voucher> voucherList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Voucher> getVoucherList() {
        return voucherList;
    }

    public void setVoucherList(List<Voucher> voucherList) {
        this.voucherList = voucherList;
    }
}
