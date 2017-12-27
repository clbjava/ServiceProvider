package com.service.provider.service.impl;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.baseTest.JunitBaseTest;
import com.service.provider.dao.dto.FlowDefineInfo;
import com.service.provider.service.FlowDefineInfoService;

public class FlowDefineInfoServiceImplTest extends JunitBaseTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(FlowDefineInfoServiceImplTest.class);
	
	@Autowired
	@Qualifier("com.service.provider.service.FlowDefineInfoService")
	FlowDefineInfoService flowDefineInfoService;

	@Test
	public void testQuery() {
		FlowDefineInfo info=new FlowDefineInfo();
		info.setFlowId("2017122700000001");
		info.setFlowName("Test");
		FlowDefineInfo infoback=flowDefineInfoService.query(info);
		LOGGER.info("{}",infoback);
	}
	
	@Test
	public void testInsert() {
		FlowDefineInfo info=new FlowDefineInfo();
		info.setFlowId("2017122700000001");
		info.setFlowName("Test");
		FlowDefineInfo infoback=flowDefineInfoService.insert(info);
		LOGGER.info("{}",infoback);
	}
	
	@Test
	public void testDelete() {
		FlowDefineInfo info=new FlowDefineInfo();
		info.setFlowId("2017122700000001");
		info.setFlowName("Test");
		FlowDefineInfo infoback=flowDefineInfoService.delete(info);
		LOGGER.info("{}",infoback);
	}
    
}
