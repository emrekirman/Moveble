package com.moveble.entity;

import com.moveble.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "measure_unit")
public class MeasurementUnit extends BaseEntity {

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
