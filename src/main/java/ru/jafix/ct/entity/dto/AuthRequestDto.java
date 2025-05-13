package ru.jafix.ct.entity.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AuthRequestDto {
    private String login;
    private String password;
}
