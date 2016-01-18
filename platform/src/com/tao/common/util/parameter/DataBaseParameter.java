package com.tao.common.util.parameter;

import org.springframework.beans.factory.InitializingBean;

import com.tao.service.SecurityService;

//@Component
public class DataBaseParameter extends Parameter implements InitializingBean{
	//@Resource
	private SecurityService platformService ;
	//@Resource
	private Parameter parameter;
	
	public static final String PLATFORMROLECACHE = "platformRoleCache";

	private void initDataBaseParameter() {
		logger.info("初始化数据库参数开始");
		logger.info("初始化数据库参数结束");
	}
	public void afterPropertiesSet() throws Exception {
		try{
			initDataBaseParameter();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("初始化数据库数据失败");
		}
	}
}
