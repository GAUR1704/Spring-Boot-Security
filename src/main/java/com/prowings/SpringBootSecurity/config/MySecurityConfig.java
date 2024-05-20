package com.prowings.SpringBootSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
            .withUser("Gaurav").password(bCryptPasswordEncoder().encode("Gaurav@2001")).roles("NORMAL")
            .and()
            .withUser("Vaibhav").password(bCryptPasswordEncoder().encode("Vaibhav@2001")).roles("ADMIN");
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public MySecurityFilter mySecurityFilter() throws Exception {
        return new MySecurityFilter();
    }

    @Configuration
    public static class MySecurityFilter {

        @Autowired
        private PasswordEncoder passwordEncoder;

        protected void configure(HttpSecurity http) throws Exception {
            http
                .csrf().disable()
                .authorizeRequests()
                    .anyRequest().authenticated() // Require authentication for any request
                .and()
                .httpBasic(); // Use HTTP Basic authentication and this is for login pop up window
//                .formLogin();   // This is for Login Page 
        }
    }
}
