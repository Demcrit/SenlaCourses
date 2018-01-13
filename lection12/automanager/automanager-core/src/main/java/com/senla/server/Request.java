package com.senla.server;

import java.io.Serializable;

public class Request implements Serializable {

	private static final long serialVersionUID = -460945216223730337L;
	private String methodName;
	private Object[] params;

	public Request(String methodName, Object[] params) {
		this.methodName = methodName;
		this.params = params;
	}

	public String getMethodName() {
		return methodName;
	}

	public Object[] getParameters() {
		return params;
	}
}
