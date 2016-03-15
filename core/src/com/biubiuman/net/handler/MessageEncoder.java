package com.biubiuman.net.handler;
import com.biubiuman.net.pojo.Message;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MessageEncoder extends MessageToByteEncoder<Message> {

	@Override
	protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out)
			throws Exception {
		System.out.println("encode");
		out.writeInt(msg.getHead());
		if (msg.getBody() != null) {
			out.writeBytes(msg.getBody().getBytes());
		}
	}

}
