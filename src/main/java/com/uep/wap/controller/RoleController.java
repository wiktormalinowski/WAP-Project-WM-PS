package com.uep.wap.controller;

import com.uep.wap.service.RoleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/roleController")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) { this.roleService = roleService;}

    @GetMapping(path = "/getRoles")
    public Iterable<com.uep.wap.model.Role> getAllRoles() {
        return roleService.getAllRole();
    }

    @PostMapping(path = "/addRole")
    public String addRole(@RequestBody com.uep.wap.dto.RoleDTO roleDTO){
        roleService.addRole(roleDTO);
        return "Role added!";
    }
}
