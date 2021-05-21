package com.company;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
//@EnableAspectJAutoProxy
public class AspectBuilder{

	@Before("execution(* com.company.Tea.getTea())")
	void AspectBefore(JoinPoint jp){
		System.out.println("Logger: " + jp.getSignature());
	}
}