package com.moveble.core.filter;

import com.moveble.core.exception.TokenNotEqualException;
import com.moveble.core.exception.TokenNotFoundException;
import com.moveble.core.helper.SessionHelper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomFilter extends OncePerRequestFilter {


    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("token");

        String sessionToken = (String) request.getSession(false).getAttribute("userSessionToken");
        if (token == null || token.isEmpty() || sessionToken == null || sessionToken.isEmpty()) {
            throw new TokenNotFoundException("Lütfen oturum açınız");
        }

        if (!sessionToken.equals(token)) {
            throw new TokenNotEqualException("Giriş bilgileriniz eşleşmiyor");
        }
        filterChain.doFilter(request, response);
    }
}
