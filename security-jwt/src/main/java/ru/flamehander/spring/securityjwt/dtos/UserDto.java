package ru.flamehander.spring.securityjwt.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class UserDto {
    private int id;
    private String username;
    private String email;
}
