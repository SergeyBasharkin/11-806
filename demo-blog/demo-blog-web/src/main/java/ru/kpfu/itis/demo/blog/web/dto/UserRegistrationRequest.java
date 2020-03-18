package ru.kpfu.itis.demo.blog.web.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserRegistrationRequest {

    @NotNull
    @NotEmpty
    private String username;
    @NotNull(message = "Test")
    @NotEmpty
    private String password;
    private String passwordRepeat;

    @Email
    @NotEmpty
    private String email;
}
