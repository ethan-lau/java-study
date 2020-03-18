package com.ethan.spring.springfamily.anno.bootstrap;

import com.ethan.spring.springfamily.anno.bean.User;
import com.ethan.spring.springfamily.anno.config.AppConfigWithConfiguration;
import com.ethan.spring.springfamily.anno.service.RoleService;
import com.ethan.spring.springfamily.anno.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationWithConfigurationBootstrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfigWithConfiguration.class);

        System.out.println(context.getBean(User.class));

        RoleService roleService = context.getBean(RoleService.class);
        UserService userService = context.getBean(UserService.class);

        System.out.println(roleService.getUser());
        System.out.println(userService.getUser());
    }

}
