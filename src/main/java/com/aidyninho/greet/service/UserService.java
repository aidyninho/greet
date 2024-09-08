package com.aidyninho.greet.service;

import com.aidyninho.greet.dao.UserDao;
import com.aidyninho.greet.model.User;

public class UserService {

    private static final UserService INSTANCE = new UserService();
    private UserDao userDao;

    private UserService() {
        this.userDao = UserDao.getInstance();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public static UserService getInstance() {
        return INSTANCE;
    }

    public boolean save(User user) {
        return userDao.save(user);
    }

    public boolean update(User user) {
        return userDao.update(user);
    }

    public boolean delete(Long id) {
        return userDao.delete(id);
    }

    public User findById(Long id) {
        return userDao.getById(id);
    }
}
