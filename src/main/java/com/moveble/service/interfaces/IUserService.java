package com.moveble.service.interfaces;

import com.moveble.entity.User;
import com.moveble.core.exception.UserNotFoundException;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User update(User user);

    User create(User user);

    User findByUsername(String username);

    void delete(int id);

    User findUserByUsernameAndPassword(String username, String password) throws UserNotFoundException;

    boolean existsByUsernameAndPassword(String username, String password) throws UserNotFoundException;
}
