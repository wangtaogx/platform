package com.tao.sdk.core.http;


public class HttpManager {
	
	private static HttpProvider defaultPovider;
	private static HttpProvider wulianCloudPovider;
	private static HttpProviderFactory httpProviderFactory = new DefaultJavaHttpProviderFactory();
	public static void setHttpProviderFactory(HttpProviderFactory factory){
		httpProviderFactory = factory;
	}
	public static HttpProvider getDefaultProvider(){
		if(defaultPovider == null)
			defaultPovider = httpProviderFactory.createDefaultHttpProvider();
		return defaultPovider;
	}
	public static HttpProvider getWulianCloudProvider(){
		if(wulianCloudPovider == null)
			wulianCloudPovider = httpProviderFactory.createWulianCloudHttpProvider();
		return wulianCloudPovider;
	}
}
