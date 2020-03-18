package com.ethan.spring.springfamily.anno.bootstrap;

import com.ethan.spring.springfamily.anno.bean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassPathBootstrap {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:classpath-user.xml");

        System.out.println(context.getBean(User.class));
    }
}
