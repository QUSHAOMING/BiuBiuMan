package com.biubiuman.net.handler;

import java.util.List;

import com.biubiuman.net.pojo.Message;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class MessageDecoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in,
			List<Object> out) throws Exception {
		if (in.readableBytes() < 4) {
			return;
		}
		System.out.println("decode");
		int head = in.readInt();
		byte[] body = new byte[in.readableBytes()];
		in.readBytes(body);
		String tempBody = new String(body, "UTF-8");
		Message message = new Message(head, tempBody);
		out.add(message);
	}

}
