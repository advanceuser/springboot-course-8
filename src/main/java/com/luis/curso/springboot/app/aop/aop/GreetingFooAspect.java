package com.luis.curso.springboot.app.aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class GreetingFooAspect {

	private static final Logger log = LoggerFactory.getLogger(GreetingFooAspect.class);

	// Desacoplando funcionalidad se mueve para GreetingServicePointCut
//	@Pointcut("execution(* com.luis.curso.springboot.app.aop.services.GreetingService.*(..))")
//	private void greetingFooAspectPointCut() {
//	};

	// @Before("execution(*
	// com.luis.curso.springboot.app.aop.services.GreetingService.*(..))")
	// Utilizando pointcut
	@Before("GreetingServicePointCuts.greetingFooAspectPointCut()")
	public void loggerBefore(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		log.info("[Foo] Antes: " + method + " invocado con los parametros" + args);
	}

	// @After("execution(*
	// com.luis.curso.springboot.app.aop.services.GreetingService.*(..))")
	// Utilizando pointcut
	@After("GreetingServicePointCuts.greetingFooAspectPointCut()")
	public void loggerAfter(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		log.info("[Foo] Despues: " + method + " con los parametros" + args);
	}

}
