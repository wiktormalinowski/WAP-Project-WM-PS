package com.uep.wap.service;

import com.uep.wap.dto.RoleDTO;
import com.uep.wap.model.Role;
import com.uep.wap.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public void addRole(RoleDTO roleDTO){
        Role role = new Role();
        role.setRole_name(roleDTO.getRole_name());
        roleRepository.save(role);
        System.out.println("role added!");
    }

    public Iterable<Role> getAllRole(){
        return roleRepository.findAll();
    }
}
