package com.moon.common.util.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DebugAop {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public DebugAop() {
    }

    @Pointcut("@annotation(com.moon.common.util.log.Debug)")
    public void logAspect() {
    }


    @Before("logAspect()")
    public void doBeforeMethod(JoinPoint joinPoint) {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println(targetName + "  " + methodName + ">>>start--------------------");

    }

    @AfterReturning(
            value = "logAspect()",
            returning = "res"
    )
    public void doAfterMethod(JoinPoint joinPoint, Object res) {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println(targetName + "  " + methodName + ">>>end--------------------");

    }

    @AfterThrowing(
            pointcut = "logAspect()",
            throwing = "e"
    )
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {

        logger.error(e.getMessage());

    }
}

