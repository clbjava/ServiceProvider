package com.service.provider.dao;

import java.util.List;

import com.service.provider.dao.dto.FlowDefineInfo;

public interface FlowDefineInfoMapper {
    int deleteByPrimaryKey(String flowId);

    int insert(FlowDefineInfo record);

    int insertSelective(FlowDefineInfo record);

    List<FlowDefineInfo> selectByPrimaryKey();

    int updateByPrimaryKeySelective(FlowDefineInfo record);

    int updateByPrimaryKey(FlowDefineInfo record);
}