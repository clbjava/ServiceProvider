/**
 * 
 */
package com.service.provider.service;

import com.service.provider.dao.dto.FlowDefineInfo;

/**
 * @author CLb
 *
 */
public interface FlowDefineInfoService {
	
	/**
	 *  查询
	 * @param flowDefineInfo 流程定义
	 * @return
	 */
	public FlowDefineInfo query(FlowDefineInfo flowDefineInfo);
	
	/**
	 *  插入
	 * @param flowDefineInfo  流程定义
	 * @return
	 */
	public FlowDefineInfo insert(FlowDefineInfo flowDefineInfo);
	
	/**
	 *  删除
	 * @param flowDefineInfo  流程定义
	 * @return
	 */
	public FlowDefineInfo delete(FlowDefineInfo flowDefineInfo);
}
