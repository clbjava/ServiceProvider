package com.service.provider.dao.dto;

public class FlowDefineInfo {
    private String flowId;

    private String flowName;

    private String flowInitParams;

    private String flowDealClass;

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public String getFlowInitParams() {
        return flowInitParams;
    }

    public void setFlowInitParams(String flowInitParams) {
        this.flowInitParams = flowInitParams;
    }

    public String getFlowDealClass() {
        return flowDealClass;
    }

    public void setFlowDealClass(String flowDealClass) {
        this.flowDealClass = flowDealClass;
    }
}