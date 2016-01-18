package com.tao.sdk.module.serverstate;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.tao.sdk.core.Configuration;
import com.tao.sdk.core.Connection;
import com.tao.sdk.core.ConnectionListener;
import com.tao.sdk.core.ConnectionManager;
import com.tao.sdk.core.Packet;
import com.tao.sdk.core.interal.AbstractModule;
import com.tao.sdk.core.netty.NettyConnection;
import com.tao.sdk.module.serverstate.handler.NamespaceHandler;
import com.tao.sdk.util.ResultUtil;
import com.tao.sdk.util.TaskExecutor;

public class ServerStateManager extends AbstractModule {
	public static final String NAMESPACE_SERVER_MASTER_CONNECTION = "http://tj.com/namespace/masterconnection";
	private static Logger logger = LoggerFactory
			.getLogger(ServerStateManager.class);
	private static ServerStateManager instance = new ServerStateManager();
	private ConnectionManager connectionManager = ConnectionManager.getInstance();
	private Map<String,Integer> serverInfoMap = new ConcurrentHashMap<String,Integer>();
	private Map<String,List<String>> serverNamespacesMap = new ConcurrentHashMap<String,List<String>>();
	private Runnable heatHeartRunnable = new Runnable() {
		
		@Override
		public void run() {
			List<Connection> connections = connectionManager.getAllServerConnections();
			for(Connection connection : connections){
				Packet packet=  new Packet();
				packet.putHeader("cmd", "heartheart");
				packet.setAction(Packet.ACTION_WRITE);
				packet.setPacketID(Packet.nextID());
				packet.setNamespace(NAMESPACE_SERVER_MASTER_CONNECTION);
				Packet result = connection.sendPacketCallBack(packet);
				if(result == null){
					reconnect(connection.getConfiguration());
				}
			}
		}
	};
	private ServerStateManager() {
		logger.debug("ServerStateManager created");
	}

	public static ServerStateManager getInstance() {
		return instance;
	}

	@Override
	public void init(ConnectionManager connectionManager) {
		super.init(connectionManager);
		TaskExecutor.getInstance().addScheduled(heatHeartRunnable, 0, 10, TimeUnit.SECONDS);
		connectionManager.putHandler("namespace",new NamespaceHandler());
	}
	@Override
	public void uninit() {
		TaskExecutor.getInstance().removeScheduled(heatHeartRunnable);
	}
	public boolean isConnected(String host, int port, String connectionID) {
		return connectionManager.isConnected(host, port, connectionID);
	}
	public void disconnect(String host, int port) {
	}
	public void disconnectAll() {
		connectionManager.disconnectAllConnection();
	}
	private void connect(Configuration configuration) {
		Connection connection = null;
		String host = configuration.getString(Configuration.KEY_CUSTOM_IP);
		int port = configuration.getIntValue(Configuration.KEY_CUSTOM_PORT);
		String connectionID = configuration
				.getString(Configuration.KEY_CONNECTION_ID);
		int loginResult = ResultUtil.RESULT_FAILED;
		connection = connectionManager.getConnection(host, port, connectionID);
		if (connection == null || !connection.isConnected()) {
			connection = createConnection(configuration);
			int result = connection.connect(host, port);
			if (result == ResultUtil.RESULT_SUCCESS) {
				loginResult = connection.login();
				if (loginResult == ResultUtil.RESULT_SUCCESS) {
					connectionManager.putConnection(host, port, connection);
					serverInfoMap.put(getServerKey(host,port), 0);
				}else{
					connection.close();
				}
			}
		}
	}

	public void connect(String userID,String password,String host,int port){
		Configuration configuration = new Configuration();
		configuration.put(Configuration.KEY_CONNECTION_TYPE, NettyConnection.TYPE_CONNECTION_NETTY);
		configuration.put(Configuration.KEY_CONNECTION_ID, userID);
		configuration.put(Configuration.KEY_CUSTOM_IP, host);
		configuration.put(Configuration.KEY_CUSTOM_PORT, port);
		configuration.put("password", password);
		connect(configuration);
	}
	private Connection createConnection(Configuration configuration) {
		Connection connection = null;
		String connectionType = configuration.getConnectionType();
		if (NettyConnection.TYPE_CONNECTION_NETTY.equals(connectionType)) {
			connection = new NettyConnection();
			connection.setConfiguration(configuration);
		} else {
			throw new UnsupportedOperationException(
					"unset connection type in configuration");
		}
		connection.addPacketListener(connectionManager.getPacketListener());
		connection.addConnectionListener(new ConnectionListener() {
			@Override
			public void disconnected(int result, Configuration configuration) {
				fireDisconnected(result, configuration);
			}
		});
		return connection;
	}
	private void fireDisconnected(int result, Configuration configuration) {
		String host = configuration.getString(Configuration.KEY_CUSTOM_IP);
		int port = configuration.getIntValue(Configuration.KEY_CUSTOM_PORT);
		String connectionID = configuration.getString(Configuration.KEY_CONNECTION_ID);
		serverInfoMap.remove(getServerKey(host, port));
		connectionManager.removeConnection(host, port, connectionID);
		if(ResultUtil.RESULT_EXCEPTION == result){
			reconnect(configuration);
		}
	}
	public void clear() {
	}
	public void loadNamespaces(){
		
	}
	private void reconnect(final Configuration configuration){
		new Thread(){
			public void run() {
				String host = configuration.getString(Configuration.KEY_CUSTOM_IP);
				int port = configuration.getIntValue(Configuration.KEY_CUSTOM_PORT);
				String connectionID = configuration.getString(Configuration.KEY_CONNECTION_ID);
				connectionManager.removeConnection(host, port, connectionID);
				connect(configuration);
			}
		}.start();
		
	}
	private String getServerKey(String host,int port){
		return host+":"+port;
	}
	
	public void putServerNamespace(String namespace){
		
	}
}
