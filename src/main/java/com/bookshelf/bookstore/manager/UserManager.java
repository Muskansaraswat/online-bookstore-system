package com.bookshelf.bookstore.manager;

import com.bookshelf.bookstore.model.User;

public interface UserManager {
    void register(User user);
    boolean login(String username, String password);
}

