package com.tao.sdk.module.user;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tao.sdk.core.http.HttpManager;
import com.tao.sdk.core.http.HttpProvider;
import com.tao.sdk.core.http.Result;
import com.tao.sdk.module.user.UserResultModel.LoginResult;
import com.tao.sdk.module.user.UserResultModel.RegisterResult;
import com.tao.sdk.util.StringUtil;

public class UserManager {
	private Logger logger = LoggerFactory.getLogger(UserManager.class);
	protected HttpProvider httpProvider = HttpManager.getWulianCloudProvider();
//	public static final String BASEURL = "http://192.168.0.228:80";
//	public static final String BASEURL = "http://v2.wuliancloud.com:52181/AMS";
	public static String BASEURL = "https://v2.wuliancloud.com:52189/AMS";
	private static UserManager instance = new UserManager();
	private String userToken;
	private UserManager(){
		logger.debug("UserManager created");
	}
	public static UserManager getInstance(){
		return instance;
	}
	
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	/**
	 * 
	 * must contains values are username,passwd,IMEI,OS,OSVER,partnerId
	 * @param user
	 * @return
	 */
	public RegisterResult register(User user){
		Map<String,String> headers = createRequestHeader("userRegist", null);
		JSONObject result =  httpProvider.post(BASEURL+"/user/access", headers,JSON.toJSONString(user));
		String status = "-1";
		String userId = "";
		if(result != null){
		  status = statusFromJsonObject(result);
		  if("0".equals(status)){
			  JSONObject body = StringUtil.isEmpty(result.getString("body"))?null : JSON.parseObject(result.getString("body"));
			  if(body != null && body.containsKey("userId")){
				  userId = body.getString("userId");
			  }
		  }
		}
		RegisterResult registerResult = new RegisterResult();
		registerResult.status = status;
		registerResult.userId = userId;
		return registerResult;
	}
	/**
	 * 
	 * @param user
	 * @return
	 */
	public Result authUserName(User user){
		Map<String,String> headers = createRequestHeader("userNameAuth", null);
		JSONObject result =  httpProvider.post(BASEURL+"/user/access", headers,JSON.toJSONString(user));
		String status = "-1";
		if(result != null){
		  status = statusFromJsonObject(result);
		}
		Result authUsernameResult = new Result();
		authUsernameResult.status = status;
		return authUsernameResult;
	}
	/**
	 * must contains values are userId,password,IMEI。
	 * @param user
	 * @return
	 */
	public LoginResult login(User user){
		Map<String,String> headers = createRequestHeader("userLogin", null);
		JSONObject result =  httpProvider.post(BASEURL+"/user/access", headers,JSON.toJSONString(user));
		return doWithLoginResult(result);
	}
	private LoginResult doWithLoginResult(JSONObject result) {
		String status = "-1";
		String token = "";
		if(result != null){
		  status = statusFromJsonObject(result);
		  if("0".equals(status)){
			  JSONObject body = StringUtil.isEmpty(result.getString("body"))?null : JSON.parseObject(result.getString("body"));
			  if(body != null && body.containsKey("token")){
				  token = body.getString("token");
				  userToken = token;
			  }
		  }
		}
		LoginResult loginResult = new LoginResult();
		loginResult.status = status;
		loginResult.token = token;
		return loginResult;
	}
	
	/**
	 *   must contains values are hirdId,password,IMEIt
	 * @param user
	 * @return
	 */
	public LoginResult loginByThirdId(User user){
		Map<String,String> headers = createRequestHeader("userLoginByThird", null);
		JSONObject result =  httpProvider.post(BASEURL+"/user/access", headers,JSON.toJSONString(user));
		return doWithLoginResult(result);
	}
	/**
	 * must contains values are userId,email
	 * @param user
	 * @return
	 */
	public boolean bindUserMail(User user){
		Map<String,String> headers = createRequestHeader("userMailChange", userToken);
		JSONObject result =  httpProvider.post(BASEURL+"/user/access", headers,JSON.toJSONString(user));
		boolean success = false;
		if(result != null){
			 String status = statusFromJsonObject(result);
			  if("0".equals(status)){
				  success = true;
			  }
			}
		return success;
	}
	/**
	 * 
	 * @param data
	 * @return
	 */
	public Result updateUserDetailData(UserDetailData data){
		Map<String,String> headers = createRequestHeader("userUpdate", userToken);
		JSONObject result =  httpProvider.post(BASEURL+"/user/access", headers,JSON.toJSONString(data));
		String status = "-1";
		if(result != null){
			  status = statusFromJsonObject(result);
		}
		Result updateResult = new Result();
		updateResult.status = status;
		return updateResult;
	}
	
	/**
	 * must contains values are  mail
	 * @param user
	 * @return
	 */
	public Result resetPassword(User user){
		Map<String,String> headers = createRequestHeader("resetPasswd", null);
		JSONObject result =  httpProvider.post(BASEURL+"/user/access", headers,JSON.toJSONString(user));
		String status = "-1";
		if(result != null){
			  status = statusFromJsonObject(result);
		}
		Result resetPasswordResult = new Result();
		resetPasswordResult.status = status;
		return resetPasswordResult;
	}
	public JSONObject getDeviceTopicKey(String deviceID){
		Map<String,String> headers = createRequestHeader("getDeviceMqttInfo", userToken);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("deviceId", deviceID);
		JSONObject result =  httpProvider.post(BASEURL+"/user/device", headers,jsonObject);
		String status = "-1";
		if(result != null){
			  status = statusFromJsonObject(result);
			  if("0".equals(status)){
				  JSONObject body = StringUtil.isEmpty(result.getString("body"))?null : JSON.parseObject(result.getString("body"));
				  return body;
			  }
		}
		return null;
		
	}
	
	public static String statusFromJsonObject(JSONObject result){
		String status = "-1";
		if(result != null){
			JSONObject  head = result.getJSONObject("header");
			if(head != null && head.containsKey("status")){
				status = head.getString("status");
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
	
	public LoginResult loginByThird(String partnerId, String thirdToken) {
		Map<String, String> headers = createRequestHeader(
				"loginByThird", null);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("partnerId", partnerId);
		jsonObject.put("userToken", thirdToken);
		JSONObject result = httpProvider.post(BASEURL+"/user/access", headers,
				jsonObject);
		String status = "-1";
		if (result != null) {
			status = statusFromJsonObject(result);
			if ("0".equals(status)) {
				JSONObject body = StringUtil.isEmpty(result.getString("body"))?null : JSON.parseObject(result.getString("body"));
				if (body != null && body.containsKey("token")) {
					String wulianToken = body.getString("token");
					LoginResult loginResult = new LoginResult();
					loginResult.status = status;
					loginResult.token = wulianToken;
					return loginResult;
				}
			}
		}
		
		return null;

	}
}
