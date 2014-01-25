package net.md_5.bungee.protocol.packet.rewriter;

import io.netty.buffer.ByteBuf;

public class ServerSpawnPaintingRewriter extends PacketRewriter
{

    @Override
    public void rewrite(ByteBuf in, ByteBuf out) {
        writeVarInt( in, out );
        writeString( in, out );
        rewritePosition( in, out );
        out.writeByte( in.readInt() );
    }
}
