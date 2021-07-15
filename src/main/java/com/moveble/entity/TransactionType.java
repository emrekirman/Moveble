package com.moveble.entity;

import com.moveble.entity.base.BaseEntity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "transaction_type")
@Data
public class TransactionType extends BaseEntity {

    @Column(name = "name")
    @NotNull(message = "Ad alanı boş geçilemez")
    @NotBlank(message = "Ad alanı boş geçilemez")
    private String name;

    @OneToMany(mappedBy = "transactionType")
    private List<Voucher> voucherList;

}
