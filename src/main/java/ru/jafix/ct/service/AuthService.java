package ru.jafix.ct.service;

import ru.jafix.ct.entity.dto.AuthRequestDto;

import java.util.UUID;

public interface AuthService {
    String auth(AuthRequestDto requestDto);
    void activate(UUID activateCade);
}
