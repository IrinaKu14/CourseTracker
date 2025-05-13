package ru.jafix.ct.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.jafix.ct.entity.Role;
import ru.jafix.ct.entity.User;
import ru.jafix.ct.entity.dto.UserDto;
import ru.jafix.ct.repository.UserRepository;
import ru.jafix.ct.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class UserServiceImpl implements UserService {
    //создать пользователя
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        if (userDto.getLogin() == null || userDto.getLogin().isEmpty()) {
            throw new IllegalArgumentException("login is required field");
        }
        if (userDto.getPassword() == null || userDto.getPassword().isEmpty()) {
            throw new IllegalArgumentException("password is required field");
        }
        User userForCreater = User.builder()
                .age(userDto.getAge())
                .login(userDto.getLogin())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .role(Role.builder()
                        .id(UUID.fromString("c4ae9c45-3509-4424-9c39-0c7c6febcf7a"))
                        .build())
                .build();

       userForCreater = userRepository.save(userForCreater);
        return UserDto.builder()
                .id(userForCreater.getId())
                .login(userForCreater.getLogin())
                .age(userForCreater.getAge())
                .build();
    }

    //изменить пользователя
    @Override
    public User editUser(UserDto userDto) {
        if(userDto.getId()== null){
            throw new IllegalArgumentException("id пользователя при изменении обязателен");

        }
        User userForCreater = User.builder()
                .id(userDto.getId())
                .age(userDto.getAge())
                .login(userDto.getLogin())
                .build();

        return userRepository.save(userForCreater);
    }

    //получить пользователя по id
    @Override
    public User findUserById(UUID id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("Пользовател с таким id не существует");
        }

        return userOptional.get();
    }

    //аналогично
    @Override
    public User findUserById2(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Пользовател с таким id не существует"));
    }
//получить пользователя по login
    @Override
    public User findUserByLogin(String login) {
        Optional<User> userOptional = userRepository.findByLogin(login);
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("Пользовател с таким login не существует");
        }

        return userOptional.get();
    }

    //получить список всех пользователей
    @Override
    public List<User> findAllUsers() {

        return userRepository.findAll();
    }
    //удалить пользователя по id
    @Override
    public void deleteById(UUID id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        }else {
            throw new IllegalArgumentException(String.format("Запись с id =%s, не найдена", id));
        }

    }
}
