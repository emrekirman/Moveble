package com.moveble.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LoginDto {

    @NotNull(message = "Kullanıcı adı boş geçilemez")
    @NotEmpty(message = "Kullanıcı adı boş geçilemez")
    @NotBlank(message = "Kullanıcı adı boş geçilemez")
    private String username;

    @NotNull(message = "Kullanıcı adı boş geçilemez")
    @NotEmpty(message = "Kullanıcı adı boş geçilemez")
    @NotBlank(message = "Kullanıcı adı boş geçilemez")
    private String password;
}
