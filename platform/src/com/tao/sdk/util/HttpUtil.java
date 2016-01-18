package com.tao.sdk.util;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class HttpUtil {

	
	public static int statusFromJsonObject(JSONObject result){
		int status = -1;
		if(result != null){
			JSONObject  head = result.getJSONObject("header");
			if(head != null && head.containsKey("status")){
				status = head.getIntValue("status");
			}
		}
		return status;
	}
	public static Map<String,String> createRequestHeader(String cmd,String token){
		Map<String,String> headers = new HashMap<String, String>();
		if(!StringUtil.isEmpty(cmd))
			headers.put("cmd", cmd);
		if(!StringUtil.isEmpty(token))
			headers.put("token", token);
		return headers;
	}
}
