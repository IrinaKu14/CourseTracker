package ru.jafix.ct.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jafix.ct.repository.RoleRepository;
import ru.jafix.ct.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
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
