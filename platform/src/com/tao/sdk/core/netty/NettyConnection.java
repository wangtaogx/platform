package com.tao.sdk.core.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.tao.sdk.core.JID;
import com.tao.sdk.core.Packet;
import com.tao.sdk.core.interal.AbstractConnection;
import com.tao.sdk.util.Base64;
import com.tao.sdk.util.ResultUtil;
import com.tao.sdk.util.StringUtil;

public class NettyConnection extends AbstractConnection{
	private Logger logger = LoggerFactory.getLogger(NettyConnection.class);
	public static final String TYPE_CONNECTION_NETTY = "TYPE_CONNECTION_NETTY";
	private static EventLoopGroup workerGroup = new NioEventLoopGroup();
	private Channel channel;
	private Bootstrap bootstrap = null;
	private String token = "";
	private String from = "";
	private String to = "";
	public  NettyConnection() {
	}
	private void initBootstrap(){
		bootstrap = new Bootstrap();
		bootstrap.group(workerGroup);
    	bootstrap.channel(NioSocketChannel.class); 
    	bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
    	bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel ch) throws Exception {
            	ch.pipeline().addLast(new StringEncoder());
            	ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
            	ch.pipeline().addLast(new StringDecoder());
            	MessageHandler handler = new MessageHandler();
        		handler.setConnection(NettyConnection.this);
            	ch.pipeline().addLast(handler);
            }
        });
	}
	@Override
	public int connect(String host, int port) {
		if(isConnected())
			return ResultUtil.RESULT_SUCCESS;
		initBootstrap();
		this.currentHost = host;
		this.currentPort = port;
		ChannelFuture future;
		try {
			future =bootstrap.connect(host, port).sync();
			channel = future.channel();
			return ResultUtil.RESULT_SUCCESS;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ResultUtil.RESULT_FAILED;
	}

	@Override
	public int login() {
		Packet result = loginServer();
		if(result == null)
			return ResultUtil.RESULT_FAILED;
		String status = result.getStatus();
		if(!StringUtil.equals(status, "0")){
			return ResultUtil.RESULT_FAILED;
		}
		String token = result.getBody().getString("token");
		this.token = token;
		return ResultUtil.RESULT_SUCCESS;
	}
	private Packet loginServer(){
		JSONObject body = new JSONObject();
		body.put("password",configuration.getString("password"));
		this.from = new JID(getConnectionID(),getHost()+":"+getPort(),"").toJIDString()+"/master";
		this.to = this.from;
		Packet packet=  new Packet(Packet.ACTION_WRITE,Packet.nextID(),from,to,"namespace_login");
		packet.putHeader("cmd", "login");
		Packet result = sendPacketCallBack(packet);
		return result;
	}

	@Override
	public boolean isConnected() {
		if(channel != null)
			return channel.isActive();
		return false;
	}

	@Override
	public void reconnect() {
		
	}

	@Override
	public void close() {
		if(channel != null)
			channel.close();
	}

	@Override
	public void sendPacket(Packet packet) {
		packet.putHeader("token", this.token);
		packet.setFrom(this.from);
		packet.setTo(this.to);
		if(channel != null)
			channel.writeAndFlush(encode(JSONObject.toJSONString(packet)) +"\r\n");
	}

	@Override
	public String encode(String str) {
		logger.debug("write--->"+str);
		return Base64.encodeBytes(str.getBytes());
	}

	@Override
	public String decode(String str) {
		String receiveStr =  new String(Base64.decode(str));
		logger.debug("read<---"+receiveStr);
		return receiveStr;
	}

}
