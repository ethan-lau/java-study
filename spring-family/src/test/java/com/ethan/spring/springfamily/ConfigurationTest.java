package com.ethan.spring.springfamily;

import com.ethan.spring.springfamily.anno.config.AppConfigWithConfiguration;
import com.ethan.spring.springfamily.anno.config.AppConfigWithoutConfiguration;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationTest {

    @Test
    public void testWithConfiguration() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfigWithConfiguration.class);

        for (String beanName : context.getBeanDefinitionNames()) {
            String[] aliases = context.getAliases(beanName);
            System.out.println(String.format("Bean Name (%s) aliases: (%s)", beanName, aliases));
        }
    }

    @Test
    public void testWithoutConfiguration() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfigWithoutConfiguration.class);

        for (String beanName : context.getBeanDefinitionNames()) {
            String[] aliases = context.getAliases(beanName);
            System.out.println(String.format("Bean Name (%s) aliases: (%s)", beanName, aliases));
        }

    }

}
