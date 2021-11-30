package com.tracom.officeplanner.Controllers;

import com.tracom.officeplanner.Models.ConfirmationToken;
import com.tracom.officeplanner.Models.Role;
import com.tracom.officeplanner.Models.User;
import com.tracom.officeplanner.Repository.ConfirmationTokenRepository;
import com.tracom.officeplanner.Repository.UserRepository;
import com.tracom.officeplanner.Services.EmailSenderService;
import com.tracom.officeplanner.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class AppController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private EmailSenderService emailSenderService;
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @GetMapping("/")
    public String showHomePage() {
        return "Home/index";
    }

    @GetMapping("/about")
    public String showAbout() {
        return "Home/about";
    }

    @GetMapping("/contact")
    public String getContactPage() {
        return "Home/contact";
    }

    @GetMapping("/admin_home")
    public String ShowAdminPage() {
        return "admin_home";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
//            return "login";
//        }
//
//        return "redirect:/";
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

    @GetMapping("/register_success")
    public String getRegistrationSuccess(Model model) {
        model.addAttribute("user", new User());
        return "register_success";
    }

//        @PostMapping("/register_user")
//        public String registerUser(User user){
//            userService.saveUserWithDefaultRole(user);
//
////            String siteURL= Utility.getSiteURL(request);
////            userService.sendVerificationEmail(user, siteURL);
//            return "redirect:/register_success";
//        }

    @GetMapping("/edit_user/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model) {
        User user = userRepository.getUserById(id);
        List<Role> listRoles = userService.listRoles();
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        return "edit_user";
    }

    @PostMapping("/update_user")
    public String updateUser(User user) {
        userService.save(user);
        return "redirect:/list_users";
    }
//
//    //Email verification
//    @RequestMapping(value="/register", method = RequestMethod.POST)
//    public ModelAndView registerUser(ModelAndView modelAndView, User user)
//    {
//
//        User existingUser = (User) userRepository.getUserByEmail(user.getEmail());
//        if(existingUser != null)
//        {
//            modelAndView.addObject("message","This email already exists!");
//            modelAndView.setViewName("error");
//        }
//        else
//        {
//            userService.saveUserWithDefaultRole(user);
//
//            ConfirmationToken confirmationToken = new ConfirmationToken(user);
//
//            confirmationTokenRepository.save(confirmationToken);
//
//            SimpleMailMessage mailMessage = new SimpleMailMessage();
//            mailMessage.setTo(user.getEmail());
//            mailMessage.setSubject("Complete Registration!");
//            mailMessage.setFrom("officeplannertracom@gmail.com");
//            mailMessage.setText("To confirm your account, please click here : "
//                    +"http://localhost:8080/confirm-account?token="+confirmationToken.getConfirmationToken());
//
//            emailSenderService.sendEmail(mailMessage);
//
//            modelAndView.addObject("email", user.getEmail());
//
//            modelAndView.setViewName("register_success");
//        }
//
//        return modelAndView;
//    }
//
//    @RequestMapping(value="/confirm_account", method= {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token")String confirmationToken)
//    {
//        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
//
//        if(token != null)
//        {
//            User user = (User) userRepository.getUserByEmail(token.getUser().getEmail());
//            user.setEnabled(true);
//            userService.saveUserWithDefaultRole(user);
//            modelAndView.setViewName("confirm_account");
//        }
//        else
//        {
//            modelAndView.addObject("message","The link is invalid or broken!");
//            modelAndView.setViewName("error");
//        }
//
//        return modelAndView;
//    }


    @PostMapping("/register_user")
    public String registerUser(User user, HttpServletRequest request)
            throws UnsupportedEncodingException, MessagingException {
        userService.register(user, getSiteURL(request));
        userService.saveUserWithDefaultRole(user);
        return "redirect:/register_success";
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code, Model model) {
        boolean verified = userService.verify(code);

        String pageTitle = verified? "Verification Succeeded!" : "Verification Failed";
        model.addAttribute("pageTitle", pageTitle);

        return (verified? "verify_success" : "verify_fail");

//        if (userService.verify(code)) {
//            return "verify_success";
//        } else {
//            return "verify_fail";
//        }
    }

}

