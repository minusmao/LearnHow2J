package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimerAspect {
    /* 对象方法 */
    @Around(value = "execution(* com.example.service.ProductService.*(..))")
    public Object time(ProceedingJoinPoint joinPoint) throws Throwable {
        long ms = System.currentTimeMillis();    // 获取当前时间
        Object object = joinPoint.proceed();    // 执行核心代码
        System.out.println("耗时：" + (System.currentTimeMillis() - ms) + "毫秒");

        return object;
    }
}
