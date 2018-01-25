package com.service.provider.base;

import java.lang.reflect.Method;

public class ServiceConfig {
	
	/**
	 * 服务实体类
	 */
	private SuperService service;
	
	/**
	 * 服务实体目标方法
	 */
	private Method method;
	
	/**
	 * 服务实体目标方法版本
	 */
	private String version;
	
	/**
	 *  服务实体目标方法策略编号
	 */
	private String strategy;
	
	public ServiceConfig() {
		
	}
	
	public ServiceConfig(SuperService service, Method method, String version, String strategy) {
		this.service = service;
		this.method = method;
		this.version = version;
		this.strategy = strategy;
	}

	public SuperService getService() {
		return service;
	}

	public void setService(SuperService service) {
		this.service = service;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

}
