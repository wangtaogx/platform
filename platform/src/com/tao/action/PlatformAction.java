package com.tao.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
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
	@RequestMapping(value="/uniqueID/{uniqueID}/type/{type}")
	public JSONObject registerClientAction(@PathVariable String uniqueID,@PathVariable String type){
		SessionInfo sessionInfo = new SessionInfo();
		sessionInfo.setUniqueID(uniqueID);
		sessionInfo.setType(type);
		ResultObject resultObject = securityService.register(sessionInfo);
		JSONObject result = new JSONObject();
		createResult(resultObject, result);
		if(resultObject.isSuccess()){
			result.put("code",resultObject.getData());
		}
		return result;
	}
	@ResponseBody
	@RequestMapping(value="/uniqueID/{uniqueID}/username/{username}/password/{password}")
	public JSONObject loginAction(@PathVariable String uniqueID,@PathVariable String username,@PathVariable String password){
		Users user = new Users();
		user.setUsername(username);
		user.setPassword(password);
		ResultObject resultObject = securityService.login(user, uniqueID);
		JSONObject result = new JSONObject();
		createResult(resultObject, result);
		if(resultObject.isSuccess()){
			result.put("result",resultObject.getData());
		}
		return result;
	}
	@ResponseBody
	@RequestMapping(value="/session",method = RequestMethod.POST)
	public JSONObject createSessionAction(@RequestParam String session,@RequestParam String username,@RequestParam String password){
		JSONObject result = securityService.createSession(session,username,password);
		return result;
	}
}
