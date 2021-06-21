package com.moveble.api;

import com.moveble.core.aop.annotation.ValidateHeader;
import com.moveble.core.exception.TokenAlreadyHaveException;
import com.moveble.dto.LoginDto;
import com.moveble.core.exception.UserNotFoundException;
import com.moveble.service.interfaces.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/auth")
@CrossOrigin(origins = {"https://localhost:3000", "http://localhost:3000"})
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
