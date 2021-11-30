package com.tracom.officeplanner.Controllers;

import com.tracom.officeplanner.Models.User;
import com.tracom.officeplanner.Repository.UserRepository;
import com.tracom.officeplanner.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
//
//    @GetMapping("/profile")
//    public String showProfilePage(Model model, Principal principal){
//        String email = principal.getName();
//        User user = userService.findOne(email);
//        model.addAttribute("user", userRepository.getUserByEmail(email));
//
//        return "userprofile";
//    }
}
