package com.biubiuman.net.handler;

import java.util.Date;

import com.biubiuman.net.emnu.MessageEnum;
import com.biubiuman.net.pojo.Message;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class HeadBeatHandler extends ChannelHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		if (((Message) msg).getHead() == MessageEnum.HEADBEAT.getCode()) {
			System.out.println("has read the heatbeat info!"
					+ new Date().getTime());
			System.out.println(msg);
			Message message = new Message(MessageEnum.HEADBEAT.getCode(), null);
			ctx.writeAndFlush(message);
		}
		System.out.println("next");
		ctx.fireChannelRead(msg);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		System.out.println(cause);
		ctx.close();
	}
}
