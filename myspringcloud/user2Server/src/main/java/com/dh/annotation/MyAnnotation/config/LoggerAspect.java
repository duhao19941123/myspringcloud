package com.dh.annotation.MyAnnotation.config;


import com.dh.annotation.MyAnnotation.dao.BookDao;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * @Author: DH
 * @Describe:
 * 定义日志切面
 * @Lazy 注解:容器一般都会在启动的时候实例化所有单实例 bean，如果我们想要 Spring 在启动的时候延迟加载 bean，需要用到这个注解
 * value为true、false 默认为true,即延迟加载，@Lazy(false)表示对象会在初始化的时候创建
 *
 */
@Aspect
@Component
    public class LoggerAspect {

    @Autowired
    private BookDao bookDao;

    /**
     * 定义切入点：对要拦截的方法进行定义与限制，如包、类
     */
    @Pointcut("@annotation(com.dh.annotation.MyAnnotation.config.LogAnnotation)")
    private void cut() {
        System.out.println(1234);
    }

    /**
     * 定制一个环绕通知
     * @param joinPoint
     */
    @Around("cut()")
    public void advice(ProceedingJoinPoint joinPoint){
        System.out.println("1===");
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println( bookDao.getBook().toString());
        System.out.println("4===");
    }

    //当想获得注解里面的属性，可以直接注入改注解
    @Before("cut()")
    public void record(JoinPoint joinPoint) {
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method method = ms.getMethod();

        LogAnnotation myAnnotation = method.getAnnotation(LogAnnotation.class);
        System.out.println("userName ===" + myAnnotation.userName());// 参数userName的值
        System.out.println("age===" + myAnnotation.age());// 参数age的值
        System.out.println("2===");
    }

    @After("cut()")
    public void after() {
        System.out.println("3===");
    }
}
