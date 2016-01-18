package com.tao.action.base;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;
import com.tao.common.bean.ResultObject;
 

 

public class BaseAction extends ApplicationObjectSupport{
	protected HttpServletRequest request = null;
	protected HttpServletResponse response=null;
	protected ServletContext sc=null;
  	protected HttpServletRequest  getRequest(){
 		request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
 	protected HttpServletResponse  getResponse(){
		return response;
 	}
 	protected ServletContext getSc(){
		return sc;
  	}
 	 
	protected boolean createResult(ResultObject resultObject,JSONObject result){
		boolean isDo = false;
		if(!resultObject.isSuccess()){
			result.put("status", resultObject.getFailReason());
			isDo = true;
		}
		return isDo;
	}
}