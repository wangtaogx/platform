package com.tao.sdk.core;


import com.tao.sdk.core.interal.PacketCollector;

public interface Connection {
	public static final int SOCKET_CONNECT_TIMEOUT = 3000;
	public static final int SOCKET_SO_TIMEOUT = 180500;
	public static final int REQUEST_TIMEOUT = 10000;
	public int connect(final String host, int port);
	public int login();
	public void fireDisconnected(int result);
	public boolean isConnected();
	public void  reconnect();
	public void close();
	public void addConnectionListener(ConnectionListener listener);
	public void removeConnectionListener(ConnectionListener listener);
	public void addPacketListener(PacketListener packetListener);
	public void removePacketListener(PacketListener packetListener);
	public void firePacketProcessed(Packet packet);
	public PacketCollector findPacketCollector(Packet packet);
	public void sendPacket(Packet packet);
	public Packet sendPacketCallBack(Packet packet);
	public Packet sendPacketCallBackWithProcessPacket(Packet packet);
	public String getHost() ;
	public void setHost(String host);
	public int getPort();
	public void setPort(int port);
	public String encode(String str);
	public String decode(String str);
	public void setConfiguration(Configuration configuration);
	public Configuration getConfiguration();
	public String getConnectionID();
	public void setConnectionID(String connectionID);
	
}
