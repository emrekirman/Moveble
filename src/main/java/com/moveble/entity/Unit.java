package com.moveble.entity;

import com.moveble.entity.base.BaseEntity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "unit")
@Data
public class Unit extends BaseEntity {

    @NotNull(message = "Name alanı boş geçilemez")
    @NotEmpty(message = "Name boş geçilemez")
    @Column(name = "name")
    private String name;

}
