package com.tao.service;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;
import com.tao.common.bean.ResultObject;
import com.tao.model.SessionInfo;
import com.tao.model.Users;

public interface SecurityService extends Serializable	{

	public ResultObject register(SessionInfo sessionInfo);
	public ResultObject login(Users user,String uuid);
	public JSONObject createSession(String serializableStr,String username,String password);
}
