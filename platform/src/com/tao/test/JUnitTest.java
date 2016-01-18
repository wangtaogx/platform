package com.tao.test;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tao.common.util.parameter.DataBaseParameter;
import com.tao.common.util.parameter.Parameter;
import com.tao.dao.UserDao;
import com.tao.model.Users;
import com.tao.service.SecurityService;


public class JUnitTest extends BaseTestTemplate{

	private static Logger logger = LoggerFactory.getLogger(JUnitTest.class);
	@javax.annotation.Resource
	private UserDao userDao;
	@Test
	public void testEhcache() {
		CacheManager cacheManager = CacheManager.create("classpath:ehcache.xml");
		Cache platformCache = cacheManager.getCache("platform");
		Element e = new Element("upLoadPath","c:/temp/");
		platformCache.put(e);
	}
	
	@Test
	public void testEhcache2()
	{
		CacheManager cacheManager = CacheManager.getInstance();
		Cache platformCache = cacheManager.getCache("platform");
		Object path = platformCache.get("upLoadPath").getObjectValue();
		System.out.println(path);
	}

	@Test
	public void insertUser() throws SQLException
	{
		Users u =new Users("wangtao", "wangtao");
		logger.info(u.getPassword()+"   "+u.getUsername());
		userDao.insert("UserDao.insertUser",u);
	}
	@Test
	public void updateUser() throws SQLException
	{
		Users u =new Users("wangtaoUpdate","wangtaoUpdate");
		u.setId(Long.valueOf(9));
		logger.info(u.getPassword()+"   "+u.getUsername());
		userDao.update("UserDao.updateUser",u);
	}
	@Test
	public void querytUser()
	{
		List<Users> users = userDao.getAllList("UserDao.selectAllUsers");
		Users u =users.get(0);
		logger.info(u.getPassword()+"   "+u.getUsername());
		
	}
	@Resource
	private SecurityService platformService;
	private Parameter parameter;
	@Test
	public void cache()
	{
		String username = (String)parameter.getValue("system.user.username");
		Object o = parameter.getValue(DataBaseParameter.PLATFORMROLECACHE);
		logger.info("项目的编号:"+o);
	}
	@Test
	public void testLogin(){
		Users user = new Users();
		user.setUsername("wangtao");
		user.setPassword("wangtao");
	}
}
