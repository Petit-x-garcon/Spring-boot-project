package com.group.ecommerce.Common.Logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    String LOG_FORMAT = "%s | className: %s | methodName: %s";

    @Around("execution(* com.group.ecommerce.Service..*(..))")
    public Object logServiceMethod(ProceedingJoinPoint joinPoint) throws Throwable{
        Logger log = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        String methodName =joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();

        log.info(LOG_FORMAT.formatted("Request", className, methodName));

        try{
            return joinPoint.proceed();
        }
        catch (Exception e){
            throw e;
        }
    }
}
