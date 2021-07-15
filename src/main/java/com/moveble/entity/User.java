package com.moveble.entity;

import com.moveble.entity.base.BaseEntity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "moveble_user")
@Data
public class User extends BaseEntity {

    @Column(name = "username")
    @NotNull(message = "Kullanıcı adı alanı boş geçilemez")
    @NotBlank(message = "Kullanıcı adı alanı boş geçilemez")
    private String username;

    @Column(name = "password")
    @NotNull(message = "Şifre alanı boş geçilemez")
    @NotBlank(message = "Şifre alanı boş geçilemez")
    private String password;

    @Column(name = "name")
    @NotNull(message = "Ad alanı boş geçilemez")
    @NotBlank(message = "Ad alanı boş geçilemez")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_claim", joinColumns = @JoinColumn(name = "claim_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<Claim> claimList;

}
