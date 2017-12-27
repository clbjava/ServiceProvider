package com.service.provider.dao.impl;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.baseTest.JunitBaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.provider.comm.utils.JsonMapper;
import com.service.provider.dao.FlowDefineInfoMapper;
import com.service.provider.dao.dto.FlowDefineInfo;

public class FlowDefineInfoMapperImplTest  extends JunitBaseTest{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlowDefineInfoMapperImplTest.class);
    
	@Autowired
	@Qualifier("com.service.provider.dao.FlowDefineInfoMapper")
	FlowDefineInfoMapper flowDefineInfoMapper;
	
	
	public void testDeleteByPrimaryKey() {
		
	}

	public void testInsert() {
		
	}

	public void testInsertSelective() {
		
	}
    
	@SuppressWarnings("unused")
	@Test
	public void testSelectByPrimaryKey() throws JsonProcessingException {
		JsonMapper mapper=JsonMapper.nonDefaultMapper();
		Page<FlowDefineInfo> page = PageHelper.startPage(1, 3);
		// selectAll查询出的List即为上面定义的page
		List<FlowDefineInfo>  list=flowDefineInfoMapper.selectByPrimaryKey();
		LOGGER.info("infoxx {}",mapper.toJson(list));
		// 使用PageInfo封装
		PageInfo<FlowDefineInfo> info = new PageInfo<FlowDefineInfo>(list);
		LOGGER.info("infox {}",mapper.toJson(info));
	}

	public void testUpdateByPrimaryKeySelective() {
		
	}

	public void testUpdateByPrimaryKey() {
		
	}

}
