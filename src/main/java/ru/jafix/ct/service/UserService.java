package ru.jafix.ct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jafix.ct.entity.User;
import ru.jafix.ct.entity.dto.UserDto;
import ru.jafix.ct.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class UserService {
    //создать пользователя
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDto userDto) {
        if (userDto.getLogin() == null || userDto.getLogin().isEmpty()) {
            throw new IllegalArgumentException("login is required field");
        }
        User userForCreater = User.builder()
                .age(userDto.getAge())
                .login(userDto.getLogin())
                .build();

        return userRepository.save(userForCreater);
    }

    //изменить пользователя
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
    public User findUserById(UUID id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("Пользовател с таким id не существует");
        }

        return userOptional.get();
    }

    //аналогично
    public User findUserById2(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Пользовател с таким id не существует"));
    }
//получить пользователя по login

    public User findUserByLogin(String login) {
        Optional<User> userOptional = userRepository.findByLogin(login);
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("Пользовател с таким login не существует");
        }

        return userOptional.get();
    }

    //получить список всех пользователей
    public List<User> findAllUsers() {

        return userRepository.findAll();
    }
    //удалить пользователя по id

    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }
}
