package com.miaomu.manager.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Jeff·Tang
 * @version 1.0
 * @date 2020/11/20 12:22
 */
@Component
@Aspect
public class PerMissionProxy {
    private HttpServletRequest request;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Pointcut("execution(* com.miaomu.manager.controller.*.*(..))")
    public void init() {
    }

    @Around("init()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        String s = request.getRequestURL().toString();

        return pjp.proceed();
    }
}
