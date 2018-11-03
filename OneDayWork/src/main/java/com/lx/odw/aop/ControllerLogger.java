package com.lx.odw.aop;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class ControllerLogger {

	Logger logger = LoggerFactory.getLogger(ControllerLogger.class);
	
	@Pointcut("execution(* com.lx.odw.controller.*Controller.*(..))")
	public void targetMethod() {
		
	}
	
	@Before("targetMethod()")
	public void before(JoinPoint joinPoint) {
		logger.info("before");
		
        if (joinPoint.getTarget() == null )return;
        // Make log message
        StringBuffer buffer = new StringBuffer();

        // append [class.method()]
        buffer.append(processJoinPoint(joinPoint));

        // append args
        Object[] arguments = joinPoint.getArgs();
        int argCount = 0;
        for (Object obj : arguments) {
            buffer.append("\n -arg" + argCount++ + " : ");
            // commons-lang : toStringBuilder
            if(obj != null) buffer.append(ToStringBuilder.reflectionToString(obj,ToStringStyle.JSON_STYLE));
        }
        
		logger.info(buffer.toString());
		
	}
	
	@AfterReturning(pointcut = "targetMethod()", returning = "returnValue")
    public void afterReturningTargetMethod(JoinPoint joinPoint, Object returnValue) {
		logger.info("afterReturning");
        if (joinPoint.getTarget() == null )return;
        // Make log message
        StringBuffer buffer = new StringBuffer();

        // append [class.method()]
        buffer.append(processJoinPoint(joinPoint));

        // return 의 결과값이 List<> 와 Object 에 따라 다르게 로그메세지를 출력
        // List<> 인 경우
        if (returnValue instanceof List) {
            List<?> resultList = (List<?>) returnValue;
            //List 의 size 출력
            buffer.append("resultList size : " + resultList.size() + "\n");
            //item.toString() 출력
            for (Object item : resultList) buffer.append(ToStringBuilder.reflectionToString(item,ToStringStyle.JSON_STYLE) + "\n");

        } else {
            // Object 인 경우
            if(returnValue != null) buffer.append(ToStringBuilder.reflectionToString(returnValue,ToStringStyle.JSON_STYLE));
        }

        logger.info(buffer.toString());

    }
	
	/*
     *  processJoinPoint
     *  joinPoint 에서 className 과 methodName 를 추출하여 로깅할 메세지를 생성
     *  @Param JoinPoint
     *  @return String
     */
    private String processJoinPoint(JoinPoint joinPoint) {
        // Get Target Class
        @SuppressWarnings("unused")
        Class<? extends Object> clazz = joinPoint.getTarget().getClass();
        // Get Class Name
        String className = clazz.getSimpleName();
        // Get Method Name
        String methodName = joinPoint.getSignature().getName();

        return "["+className+"."+methodName+"()]==";
    }

}
