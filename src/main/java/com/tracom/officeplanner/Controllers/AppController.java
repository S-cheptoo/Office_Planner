package com.tracom.officeplanner.Controllers;

import com.tracom.officeplanner.Models.Resource;
import com.tracom.officeplanner.Models.Role;
import com.tracom.officeplanner.Models.User;
import com.tracom.officeplanner.Repository.ResourceRepository;
import com.tracom.officeplanner.Repository.RoleRepository;
import com.tracom.officeplanner.Repository.UserRepository;
import com.tracom.officeplanner.Services.RoleService;
import com.tracom.officeplanner.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showHomePage(){
        return "index";
    }
    @GetMapping("/admin_home")
    public String ShowAdminPage() {
        return "admin_home";
    }

        @GetMapping("/login")
        public ModelAndView viewHomePage() {
            ModelAndView model = new ModelAndView();
            model.setViewName("login");
            return model;
        }

        //Register Controller
        @GetMapping("/list_users")
        public String showUsersList(Model model) {
            List<User> listUsers = userService.listUsers();
            model.addAttribute("listUsers", listUsers);
            return "list_users";
        }

        @GetMapping("/register")
        public String getUserRegistration(Model model) {
            model.addAttribute("user", new User());
            return "register";
        }

        @PostMapping("/register_user")
        public String registerUser(User user){
            userService.saveUserWithDefaultRole(user);
            return "redirect:/list_users";
        }

    @GetMapping("/edit_user/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model) {
        User user = userRepository.getUserById(id);
        List<Role> listRoles = userService.listRoles();
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        return "edit_user";
    }

    @PostMapping("/update_user")
    public String updateUser(User user){
        userService.save(user);
        return "redirect:/list_users";
    }
}

