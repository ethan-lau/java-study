package com.ethan.spring.springfamily.anno.bootstrap;

import com.ethan.spring.springfamily.anno.bean.User;
import com.ethan.spring.springfamily.anno.config.AppConfigWithoutConfiguration;
import com.ethan.spring.springfamily.anno.service.RoleService;
import com.ethan.spring.springfamily.anno.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationWithoutConfigurationBootstrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfigWithoutConfiguration.class);

        System.out.println(context.getBean(User.class));

    }

}
