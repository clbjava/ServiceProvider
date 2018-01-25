package com.service.provider.comm.dto;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 只是序列化json输出字符串，不会修改具体的值
 * @author clb
 *
 */
public class NumberSerialize extends JsonSerializer<BigDecimal>{
	
	private DecimalFormat format=new DecimalFormat("##0.00");

	@Override
	public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		if(value==null) {
			value=BigDecimal.ZERO;
		}
		gen.writeNumber(format.format(value.setScale(2, BigDecimal.ROUND_DOWN)));
	}

}
