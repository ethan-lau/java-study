package com.ethan.spring.springfamily.anno.service;

import com.ethan.spring.springfamily.anno.bean.User;
import org.springframework.beans.factory.annotation.Autowired;

//@Service
public class UserService {

    private User user;

    @Autowired
    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
