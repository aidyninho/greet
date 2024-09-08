package com.aidyninho.greet;

import com.aidyninho.greet.util.ConnectionManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class GreetApplication {

    public static void main(String[] args) {
//        SpringApplication.run(GreetApplication.class, args);
        try (Connection connection = ConnectionManager.getConnection()) {
            System.out.println(connection.getTransactionIsolation());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
