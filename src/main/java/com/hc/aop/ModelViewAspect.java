package com.hc.aop;

import com.hc.exp.CustomException;
import com.hc.exp.ModelAndViewException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ModelViewAspect {

    //设置切入点：这里直接拦截被@ModelView注解的方法
    @Pointcut("@annotation(com.hc.anno.ModelAndView)")
    public void pointcut() { }

    /**
     * 当有ModelAndView的注解的方法抛出异常的时候，做如下的处理
     */
    @AfterThrowing(pointcut="pointcut()",throwing="e")
    public void afterThrowable(Throwable e) {
        if(e instanceof CustomException){
            throw ModelAndViewException.transfer((CustomException) e);
        }
    }
}