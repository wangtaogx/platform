package com.tao.sdk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tao.sdk.util.CollectionsUtil;
import com.tao.sdk.util.StringUtil;

public class ConnectionManager {
	private Logger logger = LoggerFactory.getLogger(ConnectionManager.class);
	private Map<String,Map<String,Connection>> serverConnectionsMap  = new ConcurrentHashMap<String,Map<String,Connection>>();
	private Map<String,Handler> handlerMap = new ConcurrentHashMap<String,Handler>();
	private PacketListener packetListener = new PacketListener() {
		
		@Override
		public void processPacket(Packet packet) {
            if(packet == null || packet.getHeader()==null)
                return;
            String cmd = packet.getHeader("cmd");
            if(StringUtil.isEmpty(cmd))
                return ;
            Handler handler = handlerMap.get(cmd);
            if(handler != null)
                handler.handlerPacket(packet);
		}
	};
    public ConnectionManager(){
	}
	
	public PacketListener getPacketListener() {
		return packetListener;
	}

	public static  ConnectionManager getInstance(){
		return instance;
	}
	public boolean contains(String host,int port,String connectionID){
		Connection connection = getConnection(host, port, connectionID);
		if(connection != null)
			return true;
		return false;
	}
	public void putConnection(String host,int port,Connection connection){
		Map<String,Connection> connections = serverConnectionsMap.get(getServerKey(host,port));
		if(connections == null){
			connections = new ConcurrentHashMap<String,Connection>();
			serverConnectionsMap.put(getServerKey(host, port), connections);
		}
		connections.put(connection.getConnectionID(),connection);
	}
	private static ConnectionManager instance = new ConnectionManager();
	public Connection getConnection(String host,int port,String connectionID){
		Map<String,Connection> connections = serverConnectionsMap.get(getServerKey(host,port));
		if(connections != null){
			return connections.get(connectionID);
		}
		return null;
	}
	public void removeConnection(String host,int port,String connectionID){
		Map<String,Connection> connections = serverConnectionsMap.get(getServerKey(host,port));
		if(connections != null){
			connections.remove(connectionID);
		}
	}
	public boolean isConnected(String host,int port,String connectionID){
		Connection connection = getConnection(host, port, connectionID);
		if(connection != null)
			return connection.isConnected();
		return false;
	}
	public void sendPacket(String host,int port,String connectionID,Packet packet) {
		Connection connection = getConnection(host, port, connectionID);
		if(connection != null)
			 connection.sendPacket(packet);
	}
	public Packet sendPacketCallBack(String host,int port,String connectionID,Packet packet){
		Connection connection = getConnection(host, port, connectionID);
		if(connection != null)
			 return connection.sendPacketCallBack(packet);
		return null;
	}
    public Packet sendPacketCallBackWithProcessPacket(String host,int port,String connectionID,Packet packet){
    	Connection connection = getConnection(host, port, connectionID);
		if(connection != null)
			 return connection.sendPacketCallBackWithProcessPacket(packet);
		return null;
    }
	public void putHandler(String cmd,Handler handler){
		this.handlerMap.put(cmd, handler);
	}
	public void removeHandler(String cmd){
		this.handlerMap.remove(cmd);
	}
	public List<Connection> getAllServerConnections(){
		List<Connection> connections = new ArrayList<Connection>();
		List<Map<String, Connection>> connectionMaps = CollectionsUtil.mapConvertToList(serverConnectionsMap);
		for(Map<String,Connection> map : connectionMaps){
			List<Connection> currentServerConnections =  CollectionsUtil.mapConvertToList(map);
			connections.addAll(currentServerConnections);
		}
		return connections;
	}
    public void disconnectAllConnection(){
        for(Connection connect : getAllServerConnections()){
            connect.close();
        }
        serverConnectionsMap.clear();
    }
    private String getServerKey(String host,int port){
    	return host+":"+port;
    }
}
