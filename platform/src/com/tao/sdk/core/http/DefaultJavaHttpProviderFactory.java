package com.tao.sdk.core.http;

public class DefaultJavaHttpProviderFactory implements HttpProviderFactory{

	@Override
	public HttpProvider createDefaultHttpProvider() {
		return new DefaultHttpProvider();
	}

	@Override
	public HttpProvider createWulianCloudHttpProvider() {
		return new WulianCloudHttpProvider();
	}

}
