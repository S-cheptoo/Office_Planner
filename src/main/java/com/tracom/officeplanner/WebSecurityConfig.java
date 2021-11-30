//package com.tracom.officeplanner;
//
//import com.tracom.officeplanner.Services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private LoginSuccessHandler loginSuccessHandler;
//
//    @Bean
//   public UserDetailsService userDetailsService(){
//        return new MyUserDetailsService();
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailsService());
//        provider.setPasswordEncoder(passwordEncoder());
//
//        return provider;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}password").roles("USER")
//                .and()
//                .withUser("admin").password("{noop}password").roles("ADMIN")
//                .and()
//                .withUser("officer").password("{noop}password").roles("OFFICER");
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//                .csrf()
//                .disable()
//                .authorizeRequests()
//                .antMatchers("/dist/**", "/css/**", "/js/**", "/img/**","/","/contact","/login","/about","/register","/register_success","/careers","/c_profile","/account_verified").permitAll()
////                .antMatchers("/admin_home").hasAnyRole("ADMIN")
////                .antMatchers("/user_home").hasRole("USER")
////                .antMatchers("/officer_home").hasRole("OFFICER")
//                .antMatchers( "/admin_home/**").permitAll()
////                .antMatchers("/meetings/**","/add_meeting","/edit_meeting","/list_meetings").hasAnyRole("Admin","Officer")
////                .antMatchers("/add_resource/**", "/add_organization/**",
////                        "/add_room","/add_meeting","/edit_user","/edit_room","/edit_organization",
////                        "/edit_resource").hasRole("Admin")
////                .antMatchers("/employees","/organizations","/resources","/rooms","/list_users").authenticated()
//                .anyRequest().permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/login")
////                .defaultSuccessUrl("/admin_home")
//                .usernameParameter("email")
//                .successHandler(loginSuccessHandler)
//                .permitAll()
//                .and()
//                .logout().logoutSuccessUrl("/").permitAll();
//    }
//
////    @Override
////    public void configure(WebSecurity web) throws Exception {
////        web
////                .ignoring()
////                .antMatchers("/resources/**", "/static/**", "/dist/**","/css/**", "/js/**", "/img/**", "/icon/**");
////    }
//
//}