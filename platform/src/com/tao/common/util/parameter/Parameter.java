package com.tao.common.util.parameter;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.stereotype.Component;
//@Component
public class Parameter {
	//@Resource
	private  CacheManager cacheManager;
	private  Cache systemParmaterCache = null;
	protected static Logger logger  = LoggerFactory.getLogger(Parameter.class);
	public Object getValue(String key)
	{
		init();
		ValueWrapper e = systemParmaterCache.get(key);
		Object o = null;
		if(e != null)
		{
			o = e.get();
		}
		return o;
	}
	public void putValue(String key,Object value)
	{
		init();
		systemParmaterCache.put(key,value);
	}
	private synchronized  void init()
	{
		if(systemParmaterCache == null)
		{
			systemParmaterCache = cacheManager.getCache("systemParmater");
		}
	}

	
}
