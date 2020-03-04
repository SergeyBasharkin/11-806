package ru.kpfu.itis.demo.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class DemoAspect {

    @Pointcut("execution(public * ru.kpfu.itis.demo.aop.service.AopService.*(..))")
    public void aopServicePointcut(){}

//    @Pointcut("execution(public * ru.kpfu.itis.demo.aop.service.AopService.*(..)) && args(String, ..)")
//    public void aopServicePointcut(){}

//    @Before("aopServicePointcut()")
//    public void before(){
//        System.out.println("Hello from before advice");
//    }
//
//    @After("aopServicePointcut()")
//    public void after(){
//        System.out.println("Hello from after advice");
//    }
//
//    @AfterReturning(value = "aopServicePointcut()", returning = "result")
//    public void afterReturning(String result){
//        System.out.println("Hello from after returning advice("+result+")");
//    }
//
//    @AfterReturning(value = "aopServicePointcut()", returning = "result")
//    public void afterReturning(Date result){
//        System.out.println("Hello from after returning advice("+result+")");
//    }
//
//    @Around("aopServicePointcut()")
//    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("start exec");
//        Object proceed = joinPoint.proceed();
//        System.out.println("exec=" + proceed);
//        return proceed;
//    }
//
//    @Before("aopServicePointcut()")
//    public void before(JoinPoint joinPoint){
//        System.out.println("Start execution of " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//    }

//    @Around("aopServicePointcut()")
//    public String sayBye(ProceedingJoinPoint pjp){
//        return "Bye " + pjp.getArgs()[0];
//    }

//    @Before("@annotation(DemoBefore)")
//    public void beforeAnnotation(){
//        System.out.println("Before annotation");
//    }
}
