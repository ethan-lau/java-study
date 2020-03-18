package com.ethan.spring.springfamily.anno;

import com.ethan.spring.springfamily.anno.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringFamilyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext con = SpringApplication.run(SpringFamilyApplication.class, args);
        User bean = con.getBean(User.class);

        System.out.println(bean);
    }

}
