package com.senla.service;

import java.io.IOException;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonMapper {
	protected static final String NULL = "{null}";
	private static ObjectMapper mapper = null;

	public JsonMapper() {
		super();

		if (JsonMapper.mapper == null) {
			mapper = new ObjectMapper();
		}
	}

	public static String prepareJson(Object toWrite) {
		try {
			return mapper.writeValueAsString(toWrite);
		} catch (JsonProcessingException e) {
			return NULL;
		}
	}

	public Object jsonToObject(String str, @SuppressWarnings("rawtypes") Class clazz) {
		try {
			@SuppressWarnings("unchecked")
			Object obj = mapper.readValue(str, clazz);
			return obj;
		} catch (IOException e) {
			}
		return null;
	}
}
