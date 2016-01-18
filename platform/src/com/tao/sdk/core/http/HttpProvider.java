package com.tao.sdk.core.http;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface HttpProvider {
	public JSONObject post(String url);
	public JSONObject post(String url,Map<String,String> paramters);
	public JSONObject post(String url, Map<String,String> headers,byte[] body);
	public JSONObject post(String url, Map<String,String> headers,String body);
	public JSONObject post(String url, Map<String,String> headers,Map<String,String> paramters);
	public JSONObject post(String url, Map<String,String> headers, JSONObject jsonObject);
	public byte[] getPicture(String url);
	public boolean verificationResponse(String url);
}
