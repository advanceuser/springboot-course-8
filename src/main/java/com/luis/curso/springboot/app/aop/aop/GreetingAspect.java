package com.luis.curso.springboot.app.aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class GreetingAspect {

	private static final Logger log = LoggerFactory.getLogger(GreetingAspect.class);

	// Metodo generico para toda clas
	//Desacoplando funcionalidad,se mueve para GreetingServicePointCut
	//@Pointcut("execution(* com.luis.curso.springboot.app.aop.services.GreetingService.*(..))")
	//private void greetingLoggerPointCut() {}

	// @Before("execution(* com.luis.curso.springboot.app.aop..*.*(..))")
	// @Before("execution(*
	// com.luis.curso.springboot.app.aop.services.GreetingService.*(..))")
	// Utilizando el metodo pointcut
	@Before("GreetingServicePointCuts.greetingLoggerPointCut()")
	public void loggerBefore(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		log.info("Antes: " + method + " con los argumentos" + args);
	}

	// @After("execution(*
	// com.luis.curso.springboot.app.aop.services.GreetingService.*(..))")
	// Utilizando el pointcut
	@After("GreetingServicePointCuts.greetingLoggerPointCut()")
	public void loggerAfter(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		log.info("Despues: " + method + " con los argumentos" + args);
	}

	// @AfterReturning("execution(*
	// com.luis.curso.springboot.app.aop.services.GreetingService.*(..))")
	// Utilizando pointcut
	@AfterReturning("GreetingServicePointCuts.greetingLoggerPointCut()")
	public void loggerAfterReturning(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		log.info("Despues de retornar: " + method + " con los argumentos" + args);
	}

	// @AfterThrowing("execution(*
	// com.luis.curso.springboot.app.aop.services.GreetingService.*(..))")
	// Utilizando pointcut
	@AfterThrowing("GreetingServicePointCuts.greetingLoggerPointCut()")
	public void loggerAfterThrowing(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		log.info("Despues de lanzar la excepcion: " + method + " con los argumentos" + args);
	}

	// @Around("execution(*
	// com.luis.curso.springboot.app.aop.services.GreetingService.*(..))")
	// Utilizando pointcut
	@Around("GreetingServicePointCuts.greetingLoggerPointCut()")
	public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
		String method = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		Object result = null;
		try {
			log.info("Around Before: " + method + " con los argumentos" + args);
			result = joinPoint.proceed();
			log.info("Around After: " + method + " con los argumentos" + args);
			return result;
		} catch (Throwable e) {
			log.info("Around AfterThrowing: " + method + " con los argumentos" + args);
			throw e;
		}

	}
}
