package netty.tcpprotocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

public class MyMessageDecoder extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyMessageDecoder decode被调用");
        int i = in.readInt();
        byte[] bytes = new byte[i];
        ByteBuf byteBuf = in.readBytes(bytes);
        MessageProtocol messageProtocol = new MessageProtocol(i, bytes);
        out.add(messageProtocol);
    }
}
