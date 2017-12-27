package com.service.provider.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.service.provider.dao.FlowDefineInfoMapper;
import com.service.provider.dao.adapter.AbstractDao;
import com.service.provider.dao.dto.FlowDefineInfo;

@Repository("com.service.provider.dao.FlowDefineInfoMapper")
public class FlowDefineInfoMapperImpl extends AbstractDao implements FlowDefineInfoMapper {

	@Override
	public int deleteByPrimaryKey(String flowId) {
		try (SqlSession session = getSqlSession()) {
			FlowDefineInfoMapper mapper = session.getMapper(FlowDefineInfoMapper.class);
			return mapper.deleteByPrimaryKey(flowId);
		}
	}

	@Override
	public int insert(FlowDefineInfo record) {
		try (SqlSession session = getSqlSession()) {
			FlowDefineInfoMapper mapper = session.getMapper(FlowDefineInfoMapper.class);
			return mapper.insert(record);
		}
	}

	@Override
	public int insertSelective(FlowDefineInfo record) {
		try (SqlSession session = getSqlSession()) {
			FlowDefineInfoMapper mapper = session.getMapper(FlowDefineInfoMapper.class);
			return mapper.insertSelective(record);
		}
	}

	@Override
	public List<FlowDefineInfo> selectByPrimaryKey() {
		try (SqlSession session = getSqlSession()) {
			FlowDefineInfoMapper mapper = session.getMapper(FlowDefineInfoMapper.class);
			return mapper.selectByPrimaryKey();
		}
	}

	@Override
	public int updateByPrimaryKeySelective(FlowDefineInfo record) {
		try (SqlSession session = getSqlSession()) {
			FlowDefineInfoMapper mapper = session.getMapper(FlowDefineInfoMapper.class);
			return mapper.updateByPrimaryKeySelective(record);
		}
	}

	@Override
	public int updateByPrimaryKey(FlowDefineInfo record) {
		try (SqlSession session = getSqlSession()) {
			FlowDefineInfoMapper mapper = session.getMapper(FlowDefineInfoMapper.class);
			return mapper.updateByPrimaryKey(record);
		}
	}

}
