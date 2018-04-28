package com.aleksandrov.Knowledge.controllers;

import com.aleksandrov.Knowledge.models.Role;
import com.aleksandrov.Knowledge.services.Role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role/")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("get/{id}")
    public Role get(@PathVariable int id) {
        return roleService.getRole(id);
    }

    @PostMapping("add/")
    public Role add(@RequestBody Role role) {
        return roleService.saveRole(role);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable int id) {
        roleService.deleteRole(id);
    }

    @PutMapping("edit/")
    public Role edit(@RequestBody Role role) {
        return roleService.saveRole(role);
    }

    @GetMapping("list")
    public List<Role> list() {
        return roleService.getRoles();
    }
}
