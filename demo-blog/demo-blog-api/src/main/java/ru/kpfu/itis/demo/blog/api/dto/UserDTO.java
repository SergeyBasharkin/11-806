package ru.kpfu.itis.demo.blog.api.dto;

import lombok.Data;

@Data
public class UserDTO {

    public String username;
    public String password;
    public String email;
}
