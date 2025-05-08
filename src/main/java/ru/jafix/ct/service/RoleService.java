package ru.jafix.ct.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jafix.ct.entity.Role;
import ru.jafix.ct.repository.RoleRepository;
import ru.jafix.ct.repository.UserRepository;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

//    @Transactional
//    public void saveAndFind(){
//        Role role = new Role();
//        role.setName("Admin");
//
//        roleRepository.save(role);
//
//        if(true){
//            throw new RuntimeException();
//        }
//        System.out.println(roleRepository.findByName("Admin"));
//    }
}
