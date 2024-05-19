package ru.flamehander.spring.securityjwt.dtos;

import lombok.Data;

@Data
public class RegistrationUserDto {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;

    @Override
    public String toString() {
        return "RegistrationUserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
