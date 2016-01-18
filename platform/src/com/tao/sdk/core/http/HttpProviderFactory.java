package com.tao.sdk.core.http;

public interface HttpProviderFactory {

	public HttpProvider createDefaultHttpProvider();
	public HttpProvider createWulianCloudHttpProvider();
}
