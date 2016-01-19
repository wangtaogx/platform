package com.tao.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SessionInfo implements Serializable{

	public static final String KEY_USER_INFO = "KEY_USER_INFO";
	private String code;
	private String uniqueID;
	private String type;
	private String token;
	private long userID;
	private Map<String,Object> parampeters = new HashMap<String,Object>();
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUniqueID() {
		return uniqueID;
	}
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Object getParameter(String key){
		return parampeters.get(key);
	}
	public void putParameter(String key,Object parameter){
		parampeters.put(key, parameter);
	}
	public void removeParameter(String key){
		parampeters.remove(key);
	}
	
}
