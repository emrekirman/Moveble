package com.moveble.entity.base;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "created_date")
    protected Date createdDate;
}
