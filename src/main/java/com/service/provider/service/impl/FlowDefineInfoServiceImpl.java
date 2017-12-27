package com.service.provider.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.service.provider.comm.utils.JsonMapper;
import com.service.provider.dao.dto.FlowDefineInfo;
import com.service.provider.service.FlowDefineInfoService;
import com.service.provider.service.annotation.TradeAfter;
import com.service.provider.service.annotation.TradeBefore;
import com.service.provider.service.annotation.TradeInterceptor;

/**
 * @author clb
 *
 */
@Service("com.service.provider.service.FlowDefineInfoService")
public class FlowDefineInfoServiceImpl implements FlowDefineInfoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FlowDefineInfoServiceImpl.class);
	private static final JsonMapper JSON = JsonMapper.nonDefaultMapper();

	@Override
	@TradeInterceptor
	public FlowDefineInfo query(FlowDefineInfo flowDefineInfo) {
		LOGGER.info("FlowDefineInfoServiceImpl.query:{}", JSON.toJson(flowDefineInfo));
		FlowDefineInfo info = new FlowDefineInfo();
		info.setFlowId("2017122700000001");
		info.setFlowName("Test");
		return info;
	}

	@Override
	@TradeBefore
	@TradeAfter
	public FlowDefineInfo insert(FlowDefineInfo flowDefineInfo) {
		LOGGER.info("FlowDefineInfoServiceImpl.insert:{}", JSON.toJson(flowDefineInfo));
		FlowDefineInfo info = new FlowDefineInfo();
		info.setFlowId("2017122700000001");
		info.setFlowName("Test");
		return info;
	}

	@Override
	public FlowDefineInfo delete(FlowDefineInfo flowDefineInfo) {
		LOGGER.info("FlowDefineInfoServiceImpl.delete:{}", JSON.toJson(flowDefineInfo));
		FlowDefineInfo info = new FlowDefineInfo();
		info.setFlowId("2017122700000001");
		info.setFlowName("Test");
		return info;
	}

}
