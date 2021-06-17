package com.moveble.core.aop;

import com.moveble.core.aop.annotation.ValidateHeader;
import com.moveble.core.exception.TokenNotEqualException;
import com.moveble.core.exception.TokenNotFoundException;
import com.moveble.core.helper.SessionHelper;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class ValidateHeaderAspect {

    @Before("@annotation(validateHeader)")
    public void dBefore(ValidateHeader validateHeader) throws TokenNotEqualException, TokenNotFoundException {
        try {
            HttpServletRequest request = SessionHelper.getServletRequest();
            String token = request.getHeader("token");

            String sessionToken = (String) request.getSession(false).getAttribute("userSession");
//            SessionModel userModel = (SessionModel) request.getSession().getAttribute("scopedTarget.sessionModel");
            if (token == null || token.isEmpty() || sessionToken == null || sessionToken.isEmpty()) {
                throw new TokenNotFoundException("Lütfen oturum açınız");
            }

            if (!sessionToken.equals(token)) {
                throw new TokenNotEqualException("Giriş bilgileriniz eşleşmiyor");
            }
        } catch (Exception e) {
            throw e;
        }


    }
}
