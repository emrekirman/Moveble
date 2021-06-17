package com.moveble.service.interfaces;

import com.moveble.core.exception.TokenAlreadyHaveException;
import com.moveble.core.exception.UserNotFoundException;
import com.moveble.dto.LoginDto;

public interface ISessionService {

    String login(LoginDto loginDto) throws UserNotFoundException, TokenAlreadyHaveException;

    void logOut();
}
