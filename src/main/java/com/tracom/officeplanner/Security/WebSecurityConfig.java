package com.tracom.officeplanner.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
   private DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService (){
        return new MyUserDetailsService();
    }

    @Bean
    public DaoAuthenticationProvider daoauthenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());

        return authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoauthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/resources/**","/dist/**","/css/**", "/js/**", "/images/**" , "/" , "/login", "/register",
                        "/register_success","/verify","/verify_success","/verify_fail","/forgot-password", "/reset_password" ,"/set_password").permitAll()
                .antMatchers("/admin_home/**").authenticated()
                .antMatchers("/officer_home").hasRole("Officer")
                .antMatchers("/meetings").hasAnyRole("User","Admin","Officer")
//                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
//                .successHandler(successHandler)
//                .failureHandler(failureHandler)
                .and()
                .logout()
                .logoutSuccessUrl("/login").permitAll()
                .and()
                .csrf().disable();
//                .defaultSuccessUrl("/admin_home",true);
    }
//    @Autowired
//    private CustomFailureHandler customFailureHandler;
}
