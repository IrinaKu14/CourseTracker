package ru.jafix.ct.service;

import ru.jafix.ct.entity.dto.AuthRequestDto;

public interface AuthService {
    String auth(AuthRequestDto requestDto);
}
