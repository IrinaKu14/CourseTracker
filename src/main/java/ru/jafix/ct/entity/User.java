package ru.jafix.ct.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String login;
    @Column(name="user_age") //-- переопределение названия колонки в БД
    private int age;
//    @ManyToOne
//    @JoinColumn(name = "role_id")
//    private Role role;
    @ManyToMany
    private List<Role> role;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", age=" + age +
                '}';
    }
}
