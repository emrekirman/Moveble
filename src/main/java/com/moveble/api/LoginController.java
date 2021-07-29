package com.moveble.api;

import com.moveble.core.aop.annotation.ValidateHeader;
import com.moveble.core.exception.TokenAlreadyHaveException;
import com.moveble.dto.LoginDto;
import com.moveble.core.exception.UserNotFoundException;
import com.moveble.service.interfaces.ISessionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/api/auth")
//@CrossOrigin(origins = {"https://localhost:3000", "http://localhost:3000", "https://localhost:4200", "http://localhost:4200"})
@AllArgsConstructor
public class LoginController {

    private final ISessionService sessionService;

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
    public ResponseEntity<String> logout() {
        try {
            sessionService.logOut();
            return ResponseEntity.ok("Oturumunuz sonlandı.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "isLogged")
    public ResponseEntity<String> isLogged(@NotNull @NotBlank @RequestParam("token") String token) {
        try {
            if (sessionService.equalToken(token)) {
                return ResponseEntity.ok("Oturum bulundu");
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Oturumunuz bulunamadı.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
