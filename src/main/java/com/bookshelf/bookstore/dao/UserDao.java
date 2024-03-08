package com.bookshelf.bookstore.dao;

import com.bookshelf.bookstore.model.User;

public interface UserDao {
    void register(User user);
    User findByUsername(String username);
}

