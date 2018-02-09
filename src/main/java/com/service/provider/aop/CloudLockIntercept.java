package com.service.provider.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.service.provider.annotation.CloudLock;

@Aspect
@Component
public class CloudLockIntercept{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CloudLockIntercept.class);

	@Around(value = "@annotation(com.service.provider.annotation.CloudLock)")
	public void lockPoint(ProceedingJoinPoint joinPoint) throws Throwable {
		Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
		CloudLock redisLock = method.getAnnotation(CloudLock.class);
		String value = redisLock.value();
		if (StringUtils.isEmpty(value)) {
			value = String.valueOf(System.currentTimeMillis());
		}
		value = redisLock.sysId() + value;

		// TODO 获取锁
		boolean lock = true;
		// redis lock(key, redisLock.keepMills());
		if (!lock) {
			LOGGER.info("lock fail:{}",value);
			return;
		}

		joinPoint.proceed();

		// TODO 是否主动释放锁
		// redis releaseLock(key);

	}

}
