//package com.tracom.officeplanner.Security;
//
//import com.tracom.officeplanner.Models.User;
//import com.tracom.officeplanner.Repository.UserRepository;
//import com.tracom.officeplanner.Services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class CustomFailureHandler extends SimpleUrlAuthenticationFailureHandler {
//
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private UserRepository userRepository;
//    @Override
//    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//        //method called when login fails
//        String email = request.getParameter("email");
//        User user = userRepository.findByEmail(email);
//        if (user != null){
//            if (user.isEnabled() && user.isAccountNonLocked()){
//                if (user.getFailedAttempt()< 3 - 1){
//
//                }
//            }
//            System.out.println("user failed to login: " + email);
//        }else{
//            System.out.println("Email does not exist");
//        }
//        super.setDefaultFailureUrl("/login?error");
//        super.onAuthenticationFailure(request, response, exception);
//    }
//}
