package com.tracom.officeplanner;

import com.tracom.officeplanner.Models.User;
import com.tracom.officeplanner.Principal.UserPrincipal;
import com.tracom.officeplanner.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class MyUserDetailsService implements UserDetailsService {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException {
//        User user = (User) userRepository.getUserByEmail(Email);
////        .orElseThrow(
////                () -> new UsernameNotFoundException("User not found with username or email : " + Email));
//
//        if (user != null) {
//            return new MyUserDetails(user);
//            }
//
//        throw new UsernameNotFoundException("Could not find user with email:");
//    }

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User not found with such email : " + email));

        if (user != null) {
            return UserPrincipal.create(user);
        }

        throw new UsernameNotFoundException("User '" + email + "' not found");
    }
}



