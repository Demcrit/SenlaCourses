package com.senla.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapper {

	protected static final String NULL = "{null}";
	protected static ObjectMapper mapper = null;
	
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
			e.printStackTrace();
			return NULL;
		}
	}
	
}
