package com.moon.common.util.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptor {
    @Pointcut("execution(public * com.moon..*.getCustomers(..))")
    public void myMethod() {
    }

    @Before("myMethod()")
    public void doBeforeMethod(JoinPoint joinPoint) {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println(targetName + "  " + methodName + ">>>start***************");


    }

    @AfterReturning(
            value = "myMethod()",
            returning = "res"
    )
    public void doAfterMethod(JoinPoint joinPoint, Object res) {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println(targetName + "  " + methodName + ">>>end***************");

    }
}
