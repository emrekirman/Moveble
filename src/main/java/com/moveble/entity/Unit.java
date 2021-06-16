package com.moveble.entity;

import com.moveble.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "unit")
public class Unit extends BaseEntity {

    @NotNull(message = "Name alanı boş geçilemez")
    @NotEmpty(message = "Name boş geçilemez")
    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
