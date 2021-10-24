package com.tracom.officeplanner.Controllers;

import com.tracom.officeplanner.Models.Resource;
import com.tracom.officeplanner.Models.Role;
import com.tracom.officeplanner.Repository.RoleRepository;
import com.tracom.officeplanner.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.List;

@Repository
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleService roleService;

    public String showRolesList(Model model) {
        List<Role> listRoles = roleService.listRoles();
        model.addAttribute("roles", listRoles);
        return "listRoles";
    }
}
