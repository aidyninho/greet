package com.aidyninho.greet.dao;

public class UserDao {

    private static final UserDao INSTANCE = new UserDao();

    private UserDao() {}

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
