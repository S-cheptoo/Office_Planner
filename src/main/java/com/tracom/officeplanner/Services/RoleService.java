package com.tracom.officeplanner.Services;

import com.tracom.officeplanner.Models.Role;
import com.tracom.officeplanner.Models.User;
import com.tracom.officeplanner.Repository.RoleRepository;
import com.tracom.officeplanner.Repository.UserRepository;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    //List
    public List<Role> listRoles(){
        return roleRepository.findAll();
    }
}
