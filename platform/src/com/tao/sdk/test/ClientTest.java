package com.tao.sdk.test;

import com.tao.sdk.application.ApplicationManger;
import com.tao.sdk.module.serverstate.ServerStateManager;

public class ClientTest {

	public static void main(String[] args) {
		ApplicationManger.getInstance().startModules(null);
		ServerStateManager.getInstance().connect("server1", "server1", "127.0.1.1",9008);
		ServerStateManager.getInstance().connect("server2", "server2", "127.0.1.1",9008);
	}
}
