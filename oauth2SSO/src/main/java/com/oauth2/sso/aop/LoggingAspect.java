package com.oauth2.sso.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before(value = "execution(* com.oauth2.sso.controller.OAuth2UserController.createNewUser(..))")
    public void beforeCreateUserLogging(JoinPoint joinPoint){
        LOGGER.info("------> before method from AOP Framework");
    }
}
