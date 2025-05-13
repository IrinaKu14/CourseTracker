package ru.jafix.ct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.jafix.ct.entity.Responsable;
import ru.jafix.ct.entity.dto.AuthRequestDto;
import ru.jafix.ct.entity.dto.ErrorDto;
import ru.jafix.ct.entity.dto.SuccessDto;
import ru.jafix.ct.entity.dto.UserDto;
import ru.jafix.ct.service.AuthService;
import ru.jafix.ct.service.JwtService;
import ru.jafix.ct.service.UserService;

@RequestMapping("/api")
@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/auth")
    public ResponseEntity<?> createUser(@RequestBody AuthRequestDto authRequestDto){
        try{
            return ResponseEntity.ok(SuccessDto.builder().msg(authService.auth(authRequestDto)).build());
        }catch (Exception e){
            return ResponseEntity.badRequest()
                    .body(ErrorDto.builder()
                            .errorMsg(e.getMessage())
                            .build());
        }
    }
}
