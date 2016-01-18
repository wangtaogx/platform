package com.tao.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tao.action.base.BaseAction;
import com.tao.common.bean.ResultObject;
import com.tao.model.SessionInfo;
import com.tao.model.Users;
import com.tao.service.SecurityService;

@Controller
@RequestMapping(value="/platform")
public class PlatformAction extends BaseAction{
	@Resource
	private SecurityService securityService;
	@ResponseBody
	@RequestMapping(value="/register/{uniqueID}/{type}")
	public JSONObject registerClientAction(@PathVariable String uniqueID,@PathVariable String type){
		SessionInfo sessionInfo = new SessionInfo();
		sessionInfo.setUniqueID(uniqueID);
		sessionInfo.setType(type);
		ResultObject resultObject = securityService.register(sessionInfo);
		JSONObject result = new JSONObject();
		boolean isCreate = createResult(resultObject, result);
		if(!isCreate){
			result.put("code",resultObject.getData());
		}
		return result;
	}
	@ResponseBody
	@RequestMapping(value="/login/{code}/{username}/{password}")
	public JSONObject loginAction(@PathVariable String code,@PathVariable String username,@PathVariable String password){
		Users user = new Users();
		user.setUsername(username);
		user.setPassword(password);
		ResultObject resultObject = securityService.login(user, code);
		JSONObject result = new JSONObject();
		boolean isCreate = createResult(resultObject, result);
		if(!isCreate){
			result.put("token",resultObject.getData());
		}
		return result;
	}

}
