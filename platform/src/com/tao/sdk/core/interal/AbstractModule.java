package com.tao.sdk.core.interal;

import java.util.HashMap;
import java.util.Map;

import com.tao.sdk.core.ConnectionManager;
import com.tao.sdk.core.Module;


public class AbstractModule implements Module{
	protected ConnectionManager connectionManager ;
	private Map<String,Object> configurationMap = new HashMap<String, Object>();
	
	@Override
	public void init(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}
	@Override
	public void uninit() {
	}
	public void putParameter(String key,Object obj){
		configurationMap.put(key, obj);
	}
	
	public Object getParameter(String key){
		return configurationMap.get(key);
	}
}
