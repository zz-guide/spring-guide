package org.zz.spring.guide.annotation.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    @Pointcut(value = "execution(* org.zz.spring.guide.annotation.aop.service.CalculatorImpl.*(..))")
    public void pointCut(){}

    @Before(value = "pointCut()" )
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String arg = Arrays.toString(joinPoint.getArgs());
        System.out.println("LogAspect------>前置通知----用户xxx执行了"+methodName+"方法。。。参数是"+arg);
    }

    @After(value = "pointCut()" )
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String arg = Arrays.toString(joinPoint.getArgs());
        System.out.println("LogAspect------>后置通知----用户xxx执行了"+methodName+"方法。。。参数是"+arg);
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        String arg = Arrays.toString(joinPoint.getArgs());
        System.out.println("LogAspect------>返回通知----用户xxx执行了"+methodName+"方法。。。参数是"+arg+",结果:"+result);
    }

    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable e) {
        String methodName = joinPoint.getSignature().getName();
        String arg = Arrays.toString(joinPoint.getArgs());
        System.out.println("LogAspect------>异常通知----用户xxx执行了"+methodName+"方法。。。参数是"+arg+",异常信息:"+e);
    }

    @Around(value = "pointCut()" )
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String arg = Arrays.toString(joinPoint.getArgs());
        System.out.println("LogAspect------>环绕通知----用户xxx执行了"+methodName+"方法。。。参数是"+arg);

        Object result = null;
        try {
            System.out.println("=== 环绕中 ===");
            result = joinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("=== 环绕异常 ==="+e);
        } finally {
            System.out.println("=== 环绕finally ===");
        }

        return result;
    }
}
