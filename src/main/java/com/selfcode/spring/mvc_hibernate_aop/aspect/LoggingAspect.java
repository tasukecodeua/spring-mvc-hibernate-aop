package com.selfcode.spring.mvc_hibernate_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Around("execution(* com.selfcode.spring.mvc_hibernate_aop.dao.*.*(..))")
    public Object aroundAllRepoMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature =
                (MethodSignature) proceedingJoinPoint.getSignature();
        String mname = methodSignature.getName();
        System.out.println("Begin of " + mname);
        Object targetMethodResult = proceedingJoinPoint.proceed();
        System.out.println("End of " + mname);
        return targetMethodResult;
    }
}
