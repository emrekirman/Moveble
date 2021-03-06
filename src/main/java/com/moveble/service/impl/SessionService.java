package com.moveble.service.impl;

import com.moveble.core.exception.TokenAlreadyHaveException;
import com.moveble.core.exception.UserNotFoundException;
import com.moveble.core.helper.SessionHelper;
import com.moveble.core.helper.TokenGenerator;
import com.moveble.dto.LoginDto;
import com.moveble.entity.User;
import com.moveble.service.interfaces.ISessionService;
import com.moveble.service.interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@AllArgsConstructor
public class SessionService implements ISessionService {

    private final IUserService userService;

    @Override
    public String login(LoginDto loginDto) throws UserNotFoundException, TokenAlreadyHaveException {
        try {
            User user = userService.findUserByLoginDto(loginDto);


            String token = TokenGenerator.generateToken();

            HttpServletRequest request = SessionHelper.getServletRequest();

            if (request.getSession().getAttribute("userSessionToken") != null) {
                throw new TokenAlreadyHaveException("Oturumunuz zaten mevcut");
            }

            request.getSession(true).setAttribute("userSessionToken", token);
            request.getSession(true).setAttribute("userSessionName", user.getUsername());

            return token;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void logOut() {
        try {
            SessionHelper.getServletRequest().getSession().invalidate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String getToken() {
        return SessionHelper.getServletRequest().getSession().getAttribute("userSessionToken").toString();
    }

    @Override
    public boolean equalToken(String token) {
        return this.getToken().equals(token);
    }
}
