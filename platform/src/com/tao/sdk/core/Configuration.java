package com.tao.sdk.core;

import java.util.Properties;

import com.alibaba.fastjson.JSONObject;

public class Configuration extends JSONObject{
	public static final String KEY_CUSTOM_IP = "KEY_CUSTOM_IP";
	public static final String KEY_CUSTOM_PORT = "KEY_CUSTOM_PORT";
	public static final String KEY_CONNECTION_TYPE = "KEY_CONNECTION_TYPE";
	public static final String KEY_CONNECTION_ID= "KEY_CONNECTION_ID";
	public static final String KEY_MQTT_CONNECTION_INFO = "KEY_MQTT_CONNECTION_INFO";
	public static final String KEY_MQTT_TOPIC_CONNECTION_ID = "KEY_MQTT_TOPIC_CONNECTION_ID";
	
	public Configuration(){
		
	}
	public Configuration(Properties properties){
	}
	
	public String getConnectionType(){
		return getString(KEY_CONNECTION_TYPE);
	}
	public void setConnectionType(String type){
		put(KEY_CONNECTION_TYPE,type);
	}
}
