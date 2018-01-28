package com.senla.server;

import java.io.Serializable;

public class Response implements Serializable {

	private static final long serialVersionUID = -8193648420657069456L;
	private Boolean ok;
	private Object object;

	public Response(Object object) {
		if (object == null) {
			ok = false;
		} else {
			ok = true;
			this.object = object;
		}
	}

	public Boolean isOk() {
		return ok;
	}

	public Object getObject() {
		return object;
	}
}
