package com.moveble.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.moveble.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "current")
public class Current extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "current")
    @JsonIgnore
    private List<VoucherMove> voucherMoveList;
}
