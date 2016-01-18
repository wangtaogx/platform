package com.tao.service.imp;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import net.sf.ehcache.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tao.common.bean.ResultObject;
import com.tao.common.bean.Status;
import com.tao.dao.UserDao;
import com.tao.model.SessionInfo;
import com.tao.model.Users;
import com.tao.service.SecurityService;
@Service("platformService")
public class SecurityServiceImp  implements SecurityService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private UserDao userDao;
	private Map<String,SessionInfo> loginedSessionMap = new ConcurrentHashMap<String,SessionInfo>();
	private Map<String,SessionInfo> unLoginedSessionMap = new ConcurrentHashMap<String,SessionInfo>();
	private Logger logger = LoggerFactory.getLogger(SecurityServiceImp.class);
	public ResultObject login(Users user,String code) {
		ResultObject result = new ResultObject();
		SessionInfo sessionInfo = unLoginedSessionMap.get(code);
		if(sessionInfo == null){
			result.setSuccess(false);
			result.setFailReason(Status.STATUS_NOT_AUTHENTIC);
			return result;
		}
		List<Users> users = userDao.getAllListByObj("UserDao.login",user);
		if(users.size() <= 0){
			result.setSuccess(false);
			result.setFailReason(Status.STATUS_NO_USER);
			return result;
		}
		Users tokenUser = users.get(0);
		String token = UUID.randomUUID().toString();
		sessionInfo.putParameter(SessionInfo.KEY_USER_INFO,tokenUser);
		sessionInfo.setUserID(tokenUser.getId());
		loginedSessionMap.put(token, sessionInfo);
		unLoginedSessionMap.remove(code);
		result.setSuccess(true);
		result.setData(token);
		return result;
	}
	@Override
	public ResultObject register(SessionInfo sessionInfo) {
		ResultObject result = new ResultObject();
		String uniqueID = sessionInfo.getUniqueID();
		String type = sessionInfo.getType();
		String code = uniqueID+type;
		sessionInfo.setCode(code);
		unLoginedSessionMap.put(code, sessionInfo);
		result.setSuccess(true);
		result.setData(code);
		return result;
	}
}
