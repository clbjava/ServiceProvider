package com.service.provider.comm.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestJackSon implements Serializable {

	private static final long serialVersionUID = -5678706072458359247L;
	
	//@JsonProperty("TEST_ID")
	private List<Dto> testId;
    
	@JsonProperty("testId")
	public List<Dto> getTestId() {
		return testId;
	}
    
	@JsonProperty("TEST_ID")
	public void setTestId(List<Dto> testId) {
		this.testId = testId;
	}

}
