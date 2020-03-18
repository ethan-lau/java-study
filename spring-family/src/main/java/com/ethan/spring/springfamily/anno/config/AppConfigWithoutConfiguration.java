package com.ethan.spring.springfamily.anno.config;

import com.ethan.spring.springfamily.anno.bean.User;
import com.ethan.spring.springfamily.anno.service.RoleService;
import com.ethan.spring.springfamily.anno.service.UserService;
import org.springframework.context.annotation.Bean;

public class AppConfigWithoutConfiguration {

    @Bean
    public User user() {
        System.out.println("new user");
        return new User();
    }


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
