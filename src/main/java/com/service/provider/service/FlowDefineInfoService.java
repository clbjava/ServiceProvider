/**
 * 
 */
package com.service.provider.service;

import com.service.provider.dao.dto.FlowDefineInfo;

/**
 * @author clb
 *
 */
public interface FlowDefineInfoService {
	
	/**
	 * 
	 * @param flowDefineInfo
	 * @return
	 */
	public FlowDefineInfo query(FlowDefineInfo flowDefineInfo);
	
	/**
	 * 
	 * @param flowDefineInfo
	 * @return
	 */
	public FlowDefineInfo insert(FlowDefineInfo flowDefineInfo);
	
	/**
	 * 
	 * @param flowDefineInfo
	 * @return
	 */
	public FlowDefineInfo delete(FlowDefineInfo flowDefineInfo);
}
