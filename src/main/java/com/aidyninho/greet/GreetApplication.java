package com.aidyninho.greet;

import com.aidyninho.greet.dao.UserDao;
import com.aidyninho.greet.model.User;
import com.aidyninho.greet.util.ConnectionManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class GreetApplication {

    public static void main(String[] args) {
        UserDao userDao = UserDao.getInstance();

        System.out.println(userDao.save(new User(null, "John", "Doe")));

        System.out.println(userDao.getById(1L));

        System.out.println(userDao.update(new User(1L, "NotJohn", "NotDoe")));

        System.out.println(userDao.delete(1L));

    }

}
