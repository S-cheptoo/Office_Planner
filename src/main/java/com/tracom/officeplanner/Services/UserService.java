package com.tracom.officeplanner.Services;

import com.tracom.officeplanner.Models.Resource;
import com.tracom.officeplanner.Models.Role;
import com.tracom.officeplanner.Models.User;
import com.tracom.officeplanner.Repository.RoleRepository;
import com.tracom.officeplanner.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;


    public void saveUserWithDefaultRole(User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Role roleUser =roleRepository.getRoleByName("User");
        user.addRole(roleUser);
        userRepository.save(user);
    }

    public void save(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    //List
    public List<User> listUsers(){
        return userRepository.findAll();
    }
    //Deleting
    public void deleteUser(Integer user_id){
        userRepository.deleteById(user_id);
    }
    //Editing
    public User editUser(Integer user_id)
    {
        return userRepository.getUserById(user_id);
    }

    public List<Role> listRoles() {
        return roleRepository.findAll();
    }

    public User get(Integer id){
        return userRepository.getUserById(id);
    }

}
