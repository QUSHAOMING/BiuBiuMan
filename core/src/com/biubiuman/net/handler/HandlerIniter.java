package com.biubiuman.net.handler;

import com.biubiuman.game.controller.Controller;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class HandlerIniter extends ChannelInitializer<SocketChannel>{

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ch.pipeline().addLast(new MessageDecoder());
		ch.pipeline().addLast(new MessageEncoder());
		ch.pipeline().addLast(new Controller());
	}


}
