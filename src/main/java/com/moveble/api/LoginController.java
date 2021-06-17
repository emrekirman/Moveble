package com.moveble.api;

import com.moveble.core.aop.annotation.ValidateHeader;
import com.moveble.dto.LoginDto;
import com.moveble.entity.User;
import com.moveble.core.exception.UserNotFoundException;
import com.moveble.core.helper.TokenGenerator;
import com.moveble.service.impl.UserService;
import com.moveble.core.session.SessionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/login")
public class LoginController {

    private SessionModel sessionModel;

    private UserService userService;

    @Autowired
    public LoginController(SessionModel sessionModel, UserService userService) {
        this.sessionModel = sessionModel;
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDto loginDto) throws UserNotFoundException {
        try {
            User user = userService.findUserByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());


            String token = TokenGenerator.generateToken();

            sessionModel.setUsername(user.getUsername());
            sessionModel.setToken(token);

            return ResponseEntity.ok(token);
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "getSession")
    @ValidateHeader
    public ResponseEntity<?> getSession() {
        return ResponseEntity.ok(sessionModel.getUsername());
    }
}
