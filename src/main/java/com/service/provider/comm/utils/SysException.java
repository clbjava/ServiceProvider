package com.service.provider.comm.utils;

import org.springframework.core.NestedRuntimeException;

public class SysException extends NestedRuntimeException {

	private static final long serialVersionUID = -8717979018380526999L;

	public SysException(String msg) {
		super(msg);
	}

	public SysException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
