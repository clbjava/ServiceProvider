/**
 * 
 */
package com.service.provider.service;

/**
 * @author clb
 *
 */
@FunctionalInterface
public interface ServiceTemplate<E, T> {
	
    /**
     * 目标服务
     * @param request
     * @return
     */
	public T execute(E request);

}
