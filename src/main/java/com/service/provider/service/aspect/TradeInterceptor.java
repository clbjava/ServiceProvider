package com.service.provider.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.service.provider.comm.utils.JsonMapper;
import com.service.provider.dao.dto.FlowDefineInfo;

/**
 * 
 * @author CLb
 *
 */
@Aspect
@Service("com.service.provider.service.aspect.TradeInterceptor")
public class TradeInterceptor{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TradeInterceptor.class);
	private static final JsonMapper JSON=JsonMapper.nonDefaultMapper();
	
	@Around("@annotation(com.service.provider.service.annotation.TradeInterceptor)")
	public synchronized Object tradeInterceptor(ProceedingJoinPoint pro) throws Throwable {
		LOGGER.info("TradeInterceptor.tradeInterceptor before:{}",JSON.toJson(pro.getArgs()));
		Object[] args=pro.getArgs();
		FlowDefineInfo info=(FlowDefineInfo) args[0];
		LOGGER.info("TradeInterceptor.tradeInterceptor FlowDefineInfo:{}",JSON.toJson(info));
		Object object=pro.proceed();
		LOGGER.info("TradeInterceptor.tradeInterceptor after:{}",JSON.toJson(object));
		return object;
	}
	
	
	@Before("@annotation(com.service.provider.service.annotation.TradeBefore)")
	public synchronized void tradeBefore(JoinPoint joinPoint) throws Throwable {
		LOGGER.info("TradeInterceptor.tradeBefore before:{}",JSON.toJson(joinPoint.getArgs()));
		return;
	}
	
	@After("@annotation(com.service.provider.service.annotation.TradeAfter)")
	public synchronized void tradeAfterr(JoinPoint joinPoint) throws Throwable {
		LOGGER.info("TradeInterceptor.tradeAfterr after:{}",JSON.toJson(joinPoint.getArgs()));
	}

}