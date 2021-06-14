package com.moveble.service.interfaces;

import com.moveble.entity.TransactionType;
import com.moveble.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User update(User user);

    User create(User user);

    User findByUsername(String username);

    void delete(int id);
}
