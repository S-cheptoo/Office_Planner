//package com.tracom.officeplanner;
//
//import com.tracom.officeplanner.Repository.UserRepository;
//import org.apache.naming.factory.SendMailFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email)
//            throws UsernameNotFoundException {
//        User user = (User) userRepository.getUserByEmail(email);
//
//        if (user != null) {
//                return new MyUserDetails(user);
//}
//
//       return new UsernameNotFoundException("Could not find user with email: " +email);
//    }
//
//}
