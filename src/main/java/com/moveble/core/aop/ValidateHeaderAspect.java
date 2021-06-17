package com.moveble.core.aop;

import com.moveble.core.aop.annotation.ValidateHeader;
import com.moveble.core.exception.TokenNotEqualException;
import com.moveble.core.exception.UserNotFoundException;
import com.moveble.core.session.SessionModel;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Aspect
@Component
public class ValidateHeaderAspect {

    private SessionModel sessionModel;

    @Autowired
    public ValidateHeaderAspect(SessionModel sessionModel) {
        this.sessionModel = sessionModel;
    }

    @Before("@annotation(validateHeader)")
    public void dBefore(ValidateHeader validateHeader) throws UserNotFoundException, TokenNotEqualException {
        try {
            HttpServletRequest request = currentRequest();
            String token = request.getHeader("token");

            if (token == null || token.isEmpty() || sessionModel.getToken().isEmpty()) {
                throw new UserNotFoundException("Lütfen oturum açınız");
            }

            if (sessionModel.getToken().equals(token)) {
                throw new TokenNotEqualException("Giriş bilgileriniz eşleşmiyor");
            }
        } catch (Exception e) {
            throw e;
        }


    }


    private HttpServletRequest currentRequest() {
        // Use getRequestAttributes because of its return null if none bound
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return Optional.ofNullable(servletRequestAttributes).map(ServletRequestAttributes::getRequest).orElse(null);
    }
}
