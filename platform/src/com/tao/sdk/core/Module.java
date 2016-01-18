package com.tao.sdk.core;

public interface Module {

	public void init(ConnectionManager connectionManager);
	public void uninit();
}
