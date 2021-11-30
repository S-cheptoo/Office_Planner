//package com.tracom.officeplanner;
//
//import java.io.IOException;
//import java.util.Collection;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.web.DefaultRedirectStrategy;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//@Component
//public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//                                        Authentication authentication) throws ServletException, IOException {
//        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
//
//        String redirectUrl = request.getContextPath();
//
//        if (userDetails.hasRole("ROLE_ADMIN")) {
//            redirectUrl += "/admin_home";
//        } else if (userDetails.hasRole("ROLE_user")) {
//            redirectUrl += "/user_home";
//        }
//        response.sendRedirect(redirectUrl);
//    }
//}
////
////        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
////        for (GrantedAuthority grantedAuthority : authorities) {
////            System.out.println("roles " + grantedAuthority.getAuthority());
////            if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
////                redirectUrl = "/user_home";
////                break;
////            } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
////                redirectUrl = "/admin_home";
////                break;
////            } else if (grantedAuthority.getAuthority().equals("ROLE_OFFICER")) {
////                redirectUrl = "/officer_home";
////                break;
////            }
////        }
////            if (redirectUrl == null) {
////                throw new IllegalStateException();
////            }
////            new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
////        }
////    }