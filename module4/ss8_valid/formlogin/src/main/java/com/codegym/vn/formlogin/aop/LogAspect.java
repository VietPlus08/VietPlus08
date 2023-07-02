package com.codegym.vn.formlogin.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LogAspect {

    Logger logger = Logger.getLogger(LogAspect.class.getName());

    @Before("execution(* com.codegym.vn.formlogin.service.InforServiceImpl.*(..))")
    public void writeLogInforService(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        logger.info("Before: " + methodName);
    }

    @Around("execution(* com.codegym.vn.formlogin.service.InforServiceImpl.findAllWithPaging(..))")
    public Object writeLogFindAllWithPaging(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Arround before call: " + methodName);
        Object result = joinPoint.proceed();
        logger.info("Around after call: " + methodName);
        return result;
    }

}
