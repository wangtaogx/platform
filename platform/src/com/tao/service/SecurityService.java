package com.tao.service;

import java.io.Serializable;

import com.tao.common.bean.ResultObject;
import com.tao.model.SessionInfo;
import com.tao.model.Users;

public interface SecurityService extends Serializable	{

	public ResultObject login(Users user,String code);
	public ResultObject register(SessionInfo sessionInfo);
}
