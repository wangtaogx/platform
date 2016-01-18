package com.tao.sdk.core.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import com.alibaba.fastjson.JSONObject;
import com.tao.sdk.core.Packet;
import com.tao.sdk.core.interal.PacketCollector;
import com.tao.sdk.util.StringUtil;

public class MessageHandler extends ChannelInboundHandlerAdapter {

	private NettyConnection connection ;
	private String message = "";
	public NettyConnection getConnection() {
		return connection;
	}

	public void setConnection(NettyConnection connection) {
		this.connection = connection;
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		message += msg;
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		if(StringUtil.isEmpty(message))
    		return ;
		String receiveStr = connection.decode(message);
		message = "";
		Packet packet = JSONObject.parseObject(receiveStr,Packet.class);
		PacketCollector collector = connection.findPacketCollector(packet);
		if(collector != null){
			if(collector.isProcess()){
				connection.findPacketCollector(packet);
			}
			collector.processPacket(packet);
		}else{
			connection.findPacketCollector(packet);
		}
		
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		super.channelInactive(ctx);
		System.out.println("channel inactive ");
		
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		System.out.println("channel exception ");
		ctx.close();
	}

}
