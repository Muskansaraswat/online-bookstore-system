package com.bookshelf.bookstore.manager;

import com.bookshelf.bookstore.dao.UserDao;
import com.bookshelf.bookstore.model.User;

public class UserManagerImpl implements UserManager {
    private UserDao userDao;

    public UserManagerImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void register(User user) {
        userDao.register(user);
    }

    @Override
    public boolean login(String username, String password) {
        User user = userDao.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}

