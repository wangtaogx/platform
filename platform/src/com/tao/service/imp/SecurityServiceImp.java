package com.tao.service.imp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import net.sf.ehcache.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tao.common.bean.ResultObject;
import com.tao.common.bean.Status;
import com.tao.dao.UserDao;
import com.tao.model.SessionInfo;
import com.tao.model.Users;
import com.tao.sdk.util.ObjectSerializeUtil;
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
	@Override
	public ResultObject register(SessionInfo sessionInfo) {
		ResultObject result = new ResultObject();
		String uniqueID = sessionInfo.getUniqueID();
		String type = sessionInfo.getType();
		String code = uniqueID+type;
		sessionInfo.setCode(code);
		unLoginedSessionMap.put(uniqueID, sessionInfo);
		result.setSuccess(true);
		result.setData(code);
		return result;
	}
	public ResultObject login(Users user,String uuid) {
		ResultObject result = new ResultObject();
		SessionInfo sessionInfo = unLoginedSessionMap.get(uuid);
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
		sessionInfo.setToken(token);
		unLoginedSessionMap.remove(uuid);
		JSONObject createSessionResult = null;
		String baseURL = "http://localhost:8080/platform";
		try {
//			Map<String,String> parampeters = new HashMap<String,String>();
//			parampeters.put("username", "1");
//			parampeters.put("password", "1");
//			parampeters.put("session", ObjectSerializeUtil.getStrFromObj(sessionInfo));
//			JSONObject createResult = HttpManager.getDefaultProvider().post(baseURL+"/platform/session",null,parampeters);
//			if(createResult == null){
//				result.setSuccess(false);
//				result.setFailReason(Status.STATUS_NOT_AUTHENTIC);
//				return result;
//			}
//			createSessionResult = JSONObject.parseObject(createResult.getString("body"));
			createSessionResult = createSession( ObjectSerializeUtil.getStrFromObj(sessionInfo),"1","1");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(createSessionResult == null || !"0".equals(createSessionResult.getString("status"))){
			result.setSuccess(false);
			result.setFailReason(Status.STATUS_NOT_AUTHENTIC);
			return result;
		}
		JSONObject loginResultData = new JSONObject();
		loginResultData.put("token", token);
		loginResultData.put("baseUrl",baseURL);
		result.setSuccess(true);
		result.setData(loginResultData);
		return result;
	}
	
	public JSONObject createSession(String serializableStr,String username,String password) {
		SessionInfo sessionInfo = null;
		Object sessioninfoSerializable = null;
		JSONObject result = new JSONObject();
		try {
			sessioninfoSerializable = ObjectSerializeUtil.getObjFromStr(serializableStr);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(sessioninfoSerializable instanceof SessionInfo){
			sessionInfo = (SessionInfo)sessioninfoSerializable;
		}
		if(sessionInfo == null){
			result.put("status",Status.STATUS_NOT_AUTHENTIC);
			return result;
		}
		loginedSessionMap.put(sessionInfo.getToken(), sessionInfo);
		result.put("status", Status.STATUS_SUCESS);
		return result;
	}
}
