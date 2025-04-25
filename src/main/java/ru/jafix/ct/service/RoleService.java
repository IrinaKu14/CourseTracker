package ru.jafix.ct.service;

import org.springframework.stereotype.Service;
import ru.jafix.ct.entity.Role;
import ru.jafix.ct.repository.RoleRepository;
import ru.jafix.ct.repository.UserRepository;

@Service
public class RoleService {
    private RoleRepository roleRepository;
    public void saveAndFind(){
        Role role = new Role();
        role.setName("Admin");

        roleRepository.save(role);

        if(true){
            throw new RuntimeException();
        }
        System.out.println(roleRepository.findByName("Admin"));
    }
}
