package com.keyrene.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * 切面编程
 * Created by Administrator on 2017/5/31 0031.
 */
@Aspect
@Component
public class HttpAspect {

    public static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.keyrene.controller.*.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinpoint){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}", request.getRequestURL());

        //method
        logger.info("mothod={}",request.getMethod());

        //ip
        logger.info("ip={}",request.getRemoteAddr());

        //类方法
        logger.info("class_name={}",joinpoint.getSignature().getDeclaringTypeName()+"."+joinpoint.getSignature().getName());

        //参数
        logger.info("args[]={}",joinpoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        logger.info("2222222222");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("repomse={}",object.toString());
    }
}
