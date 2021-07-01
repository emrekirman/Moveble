package com.moveble.entity;

import com.moveble.entity.base.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "moveble_user")
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Claim> getClaimList() {
        return claimList;
    }

    public void setClaimList(List<Claim> claimList) {
        this.claimList = claimList;
    }
}
