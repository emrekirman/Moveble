package com.moveble.api;

import com.moveble.core.aop.annotation.ValidateHeader;
import com.moveble.core.exception.TokenAlreadyHaveException;
import com.moveble.core.helper.SessionHelper;
import com.moveble.dto.LoginDto;
import com.moveble.entity.User;
import com.moveble.core.exception.UserNotFoundException;
import com.moveble.core.helper.TokenGenerator;
import com.moveble.service.impl.UserService;
import com.moveble.service.interfaces.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/auth")
public class LoginController {

    private ISessionService sessionService;

    @Autowired
    public LoginController(ISessionService sessionService) {
        this.sessionService = sessionService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDto loginDto) throws UserNotFoundException, TokenAlreadyHaveException {
        try {
            String token = sessionService.login(loginDto);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "logout")
    @ValidateHeader
    public ResponseEntity<String> logout() {
        try {
            sessionService.logOut();
            return ResponseEntity.ok("Oturumunuz sonlandı.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
