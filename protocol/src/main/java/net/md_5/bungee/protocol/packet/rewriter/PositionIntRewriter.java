package net.md_5.bungee.protocol.packet.rewriter;

import io.netty.buffer.ByteBuf;

public class PositionIntRewriter extends PacketRewriter
{

    @Override
    public void rewrite(ByteBuf in, ByteBuf out) {
        writePosition( in.readInt(), in.readInt(), in.readInt(), out );
        out.writeBytes( in.readBytes( in.readableBytes() ) );
    }
}
