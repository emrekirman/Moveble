package com.moveble.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LoginDto {

    @NotNull(message = "Kullanıcı adı boş geçilemez")
    @NotEmpty(message = "Kullanıcı adı boş geçilemez")
    @NotBlank(message = "Kullanıcı adı boş geçilemez")
    private String username;

    @NotNull(message = "Kullanıcı adı boş geçilemez")
    @NotEmpty(message = "Kullanıcı adı boş geçilemez")
    @NotBlank(message = "Kullanıcı adı boş geçilemez")
    private String password;

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
}
