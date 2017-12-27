package com.service.provider.comm.utils;

import java.io.IOException;
import java.util.Optional;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonMapper {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonMapper.class);

	private  ObjectMapper mapper;

	public JsonMapper(Include include) {
		mapper = new ObjectMapper();
		if (Optional.ofNullable(include).isPresent()) {
			mapper.setSerializationInclusion(include);
		}
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		mapper.setTimeZone(TimeZone.getDefault());
	}

	public static JsonMapper nonDefaultMapper() {
		return new JsonMapper(Include.NON_DEFAULT);
	}

	public  String toJson(Object object) {
		try {
			return mapper.writeValueAsString(object);
		} catch (IOException e) {
			LOGGER.error("IOException {}", object);
			return null;
		}
	}

	public  <T> T toObjct(String string, Class<T> type) {
		try {
			return mapper.readValue(string, type);
		} catch (IOException e) {
			LOGGER.error("IOException {}", string);
			return null;
		}
	}
}
