package com.moveble.entity;

import com.moveble.entity.base.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "claim")
public class Claim extends BaseEntity {

    @Column(name = "name")
    @NotNull(message = "Ad alanı boş geçilemez")
    @NotBlank(message = "Ad alanı boş geçilemez")
    private String name;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_claim", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "claim_id"))
    private List<User> userList;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
