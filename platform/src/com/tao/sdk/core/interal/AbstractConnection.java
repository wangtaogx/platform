package com.tao.sdk.core.interal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import com.tao.sdk.core.Configuration;
import com.tao.sdk.core.Connection;
import com.tao.sdk.core.ConnectionListener;
import com.tao.sdk.core.Packet;
import com.tao.sdk.core.PacketListener;


public abstract class AbstractConnection implements Connection,Comparable<Connection>{
	protected List<PacketListener> packetListeners = new CopyOnWriteArrayList<PacketListener>();
	protected List<ConnectionListener> connectionListeners = new ArrayList<ConnectionListener>();
	protected Map<String,PacketCollector> packetCollectors = new ConcurrentHashMap<String,PacketCollector>();
	protected String currentHost;
	protected int currentPort;
	protected Configuration configuration = new Configuration();
	public void addConnectionListener(ConnectionListener listener){
		this.connectionListeners.add(listener);
	}
	public void removeConnectionListener(ConnectionListener listener){
		this.connectionListeners.remove(listener);
	}
	public void addPacketListener(PacketListener packetListener){
		this.packetListeners.add(packetListener);
	}
	public void removePacketListener(PacketListener packetListener){
		this.packetListeners.remove(packetListener);
	}
	public void fireDisconnected(int result){
		for(ConnectionListener c : connectionListeners){
			c.disconnected(result,configuration);
		}
	}
	
	public void firePacketProcessed(Packet packet){
		for(PacketListener l : packetListeners){
			l.processPacket(packet);
		}
	}
	public PacketCollector findPacketCollector(Packet packet){
		return packetCollectors.get(packet.getPacketID());
		
	}
	public void sendPacket(Packet packet){
	}
    public Packet sendPacketCallBack(Packet packet){
        return sendPacketCallBack(packet,false);
    }
	private Packet sendPacketCallBack(Packet packet,boolean isProcess){
		if(!this.isConnected())
			return null;
		Packet p = null;
		PacketFilter cmdFilter = new PacketIDFilter(packet);
		PacketCollector c = new PacketCollector(cmdFilter);
        c.setProcess(isProcess);
		this.packetCollectors.put(packet.getPacketID(),c);
		try{
			this.sendPacket(packet);
			p = c.pollResult(REQUEST_TIMEOUT);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.packetCollectors.remove(packet.getPacketID());
		}
		return p;
	}
    public Packet sendPacketCallBackWithProcessPacket(Packet packet){
        return sendPacketCallBack(packet,true);
    }
    
    public void putPacketCollector(String packetID,PacketCollector packetCollector) {
		this.packetCollectors.put(packetID,packetCollector);
	}

	public void removePacketCollector(String packetID) {
		this.packetCollectors.remove(packetID);
	}
	public String getHost() {
		return currentHost;
	}
	public void setHost(String host) {
		this.currentHost = host;
	}
	public int getPort() {
		return currentPort;
	}
	public void setPort(int port) {
		this.currentPort = port;
	}
	public Configuration getConfiguration() {
		return configuration;
	}
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
	@Override
	public int compareTo(Connection o) {
		return this.getConnectionID().compareTo(o.getConnectionID());
	}
	@Override
	public String getConnectionID() {
		return configuration.getString(Configuration.KEY_CONNECTION_ID);
	}
	@Override
	public void setConnectionID(String connectionID) {
		configuration.put(Configuration.KEY_CONNECTION_ID, connectionID);
	}
	
}
