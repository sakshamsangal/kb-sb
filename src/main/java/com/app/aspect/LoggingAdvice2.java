/*
package com.app.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAdvice2 {


    @Pointcut(value = "execution(@LogExecutionTime * *.*(..) )")
    public void myPointcut() {

    }

    @Around("myPointcut() && @annotation(methodLevelTrack)")
    public Object applicationLogger(ProceedingJoinPoint pjp, LogExecutionTime methodLevelTrack) throws Throwable {


        ObjectMapper mapper = new ObjectMapper();
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        Object[] array = pjp.getArgs();

        log.info("================START=================");
        log.info("{}, {}, request = {}", className, methodName, mapper.writeValueAsString(array));
        Object proceed = pjp.proceed();

        String value = methodLevelTrack.value();
        System.out.println("value = " + value);
        Signature signature = pjp.getSignature();
        System.out.println("signature = " + signature);

        log.info("{}, {}, response = {}", className, methodName, mapper.writeValueAsString(proceed));
        log.info("=================END================");
        return proceed;
    }

}*/
