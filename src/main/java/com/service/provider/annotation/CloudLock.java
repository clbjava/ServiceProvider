/**
 * 
 */
package com.service.provider.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface CloudLock {

	/**
	 * 锁的资源，redis的key
	 * @return
	 */
	String value() default "default";

	/**
	 * 持锁时间,单位毫秒
	 * @return
	 */
	long keepMills() default 30000;

	/**
	 * 系统码必输
	 * @return
	 */
	String sysId();
}
