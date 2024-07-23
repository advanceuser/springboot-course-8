package com.luis.curso.springboot.app.aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointCuts {

	@Pointcut("execution(* com.luis.curso.springboot.app.aop.services.GreetingService.*(..))")
	public void greetingLoggerPointCut() {
	}

	@Pointcut("execution(* com.luis.curso.springboot.app.aop.services.GreetingService.*(..))")
	public void greetingFooAspectPointCut() {
	}
}
