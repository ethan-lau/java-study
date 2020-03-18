package com.ethan.spring.springfamily.anno.config;

import com.ethan.spring.springfamily.anno.bean.User;
import com.ethan.spring.springfamily.anno.service.RoleService;
import com.ethan.spring.springfamily.anno.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AppConfigWithConfiguration {

    @Bean
    public User user() {
        System.out.println("new user");
        return new User();
    }

    @Lazy
    @Bean
    public RoleService roleService() {
        RoleService roleService = new RoleService();
        roleService.setUser(user());
        return roleService;
    }

    @Bean
    public UserService userService() {
        UserService userService = new UserService();
        userService.setUser(user());
        return userService;
    }

}
