package com.moveble.entity;

import com.moveble.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "measure_unit")
public class MeasurementUnit extends BaseEntity {

    @Column(name = "name")
    @NotNull(message = "Ad alanı boş geçilemez")
    @NotBlank(message = "Ad alanı boş geçilemez")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
