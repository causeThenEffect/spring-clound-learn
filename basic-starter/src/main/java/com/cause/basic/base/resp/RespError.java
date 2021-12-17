package com.cause.basic.base.resp;

public interface RespError {

	int getStatus();

	String getErrorCode();

	String getMessage();
}
