//package com.app.aspect;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//@Slf4j
//public class LoggingAdvice {
//
//
//    @Pointcut(value = "execution(* com.app.*.*.*(..) )")
//    public void myPointcut() {
//
//    }
//
//    @Around("myPointcut()")
//    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
//        ObjectMapper mapper = new ObjectMapper();
//        String methodName = pjp.getSignature().getName();
//        String className = pjp.getTarget().getClass().toString();
//        Object[] array = pjp.getArgs();
//
//        log.info("================START=================");
//        log.info("{}, {}, request = {}", className, methodName, mapper.writeValueAsString(array));
//        Object object = pjp.proceed();
//        log.info("{}, {}, response = {}", className, methodName, mapper.writeValueAsString(object));
//        log.info("=================END================");
//        return object;
//    }
//
//}