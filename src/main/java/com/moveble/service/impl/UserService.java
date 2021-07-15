package com.moveble.service.impl;

import com.moveble.dal.interfaces.IUserRepository;
import com.moveble.dto.LoginDto;
import com.moveble.entity.User;
import com.moveble.core.exception.UserNotFoundException;
import com.moveble.service.interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public User update(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public User create(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public User findByUsername(String username) {
        try {
            return userRepository.findByUsername(username);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) throws UserNotFoundException {
        try {
            User user = userRepository.findUserByUsernameAndPassword(username, password);
            if (user == null) {
                throw new UserNotFoundException("Kullanıcı bulunamadı");
            }
            return user;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean existsByUsernameAndPassword(String username, String password) throws UserNotFoundException {
        try {
            boolean isExist = userRepository.existsByUsernameAndPassword(username, password);
            if (!isExist) {
                throw new UserNotFoundException("Kullanıcı bulunamadı");
            }
            return isExist;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public User findUserByLoginDto(LoginDto loginDto) throws UserNotFoundException {
        try {
            User user = userRepository.findUserByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
            if (user == null) {
                throw new UserNotFoundException("Kullanıcı bulunamadı");
            }
            return user;
        } catch (Exception e) {
            throw e;
        }
    }
}
