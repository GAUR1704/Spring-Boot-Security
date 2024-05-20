// SpringBootSecurityDemoApplication.java
package com.prowings.SpringBootSecurity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import com.prowings.SpringBootSecurity.model.User;
import com.prowings.SpringBootSecurity.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringBootSecurityDemoApplication implements CommandLineRunner {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public SpringBootSecurityDemoApplication(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();

        user.setUserName("Gaurav");
        user.setEMail("gauravparate@gmail.com");
        user.setPassword(bCryptPasswordEncoder.encode("Gaurav@2001"));
        user.setRole("ROLE_NORMAL");

        this.userService.addUser(user);

        User user1 = new User();

        user1.setUserName("Vaibhav");
        user1.setEMail("vaibhavparate@gmail.com");
        user1.setPassword(bCryptPasswordEncoder.encode("Vaibhav@2001"));
        user1.setRole("ROLE_ADMIN");

        this.userService.addUser(user1);
    }
}
