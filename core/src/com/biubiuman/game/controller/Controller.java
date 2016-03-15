package com.biubiuman.game.controller;

import com.biubiuman.net.emnu.MessageEnum;
import com.biubiuman.net.pojo.Message;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class Controller extends ChannelHandlerAdapter {


	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		if (MessageEnum.LOGIN.getCode() == ((Message) msg).getHead()) {
			System.out.println(msg.toString());
		}
	}

}
