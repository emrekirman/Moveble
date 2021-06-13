package com.moveble.entity;

import com.moveble.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "product_description")
public class ProductDescription extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

     @OneToMany(mappedBy = "productDescription")
    private List<VoucherMove> voucherMoveList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<VoucherMove> getVoucherMoveList() {
        return voucherMoveList;
    }

    public void setVoucherMoveList(List<VoucherMove> voucherMoveList) {
        this.voucherMoveList = voucherMoveList;
    }
}
