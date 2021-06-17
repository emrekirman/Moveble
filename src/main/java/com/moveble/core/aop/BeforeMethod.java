package com.moveble.core.aop;

import com.moveble.core.session.SessionModel;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;

public class BeforeMethod implements MethodBeforeAdvice {

    private SessionModel sessionModel;

    @Autowired
    public BeforeMethod(SessionModel sessionModel) {
        this.sessionModel = sessionModel;
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
    }
}
