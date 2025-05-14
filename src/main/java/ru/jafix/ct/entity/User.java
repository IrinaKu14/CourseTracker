package ru.jafix.ct.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User implements UserDetails, Responsable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String email;
    private String password;
    //@Column(name="user_age") //-- переопределение названия колонки в БД
    private int age;
   @ManyToOne
//    @JoinColumn(name = "role_id")
   private Role role;
//    @ManyToMany
//    private List<Role> roles;

//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", login='" + login + '\'' +
//                ", age=" + age +
//                '}';
//    }
    @Column(name="activate_code")
    private UUID activateCade;
    private Boolean enable;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(role);
    }
    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }
    @JsonIgnore
    @Override
    public String getUsername() {
        return email;
    }
    @Override
    public boolean isEnable(){
        return enable;
    }
}
