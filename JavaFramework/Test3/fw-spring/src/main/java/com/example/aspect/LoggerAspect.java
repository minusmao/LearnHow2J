package com.example.aspect;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
    /* 对象方法 */
    @Around(value = "execution(* com.example.service.ProductService.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger logger = Logger.getLogger(Logger.class);
        BasicConfigurator.configure();
        logger.setLevel(Level.DEBUG);

//        System.out.println("start log:" + joinPoint.getSignature());
        logger.debug("开始");
        Object object = joinPoint.proceed();    // 执行核心代码
        logger.debug("结束");
//        System.out.println("end log:" + joinPoint.getSignature());

        return object;
    }
}
