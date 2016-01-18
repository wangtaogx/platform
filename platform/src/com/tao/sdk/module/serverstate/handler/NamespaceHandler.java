package com.tao.sdk.module.serverstate.handler;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tao.sdk.core.Handler;
import com.tao.sdk.core.Packet;
import com.tao.sdk.module.serverstate.ServerStateManager;

public class NamespaceHandler implements Handler {

	private ServerStateManager serverStateManager = ServerStateManager.getInstance();
	public final String OPERATION_GET = "get";
	public final String OPERATION_DELETE = "delete";
	@Override
	public void handlerPacket(Packet packet) {
		JSONObject body = packet.getBody();
		String operation = body.getString("operation");
		if(OPERATION_GET.equals(operation)){
			JSONArray namesapces = body.getJSONArray("namespace");
			for(int i=0 ; i< namesapces.size() ;i++){
				String namespace = namesapces.getString(i);
			}
		}else if(OPERATION_DELETE.equals(operation)){
			
		}
		
	}

}
