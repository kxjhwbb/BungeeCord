package net.md_5.bungee.protocol.packet.rewriter.serverside;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.packet.rewriter.PacketRewriter;

public class ServerSpawnPaintingRewriter extends PacketRewriter
{

    @Override
    public void rewrite(ByteBuf in, ByteBuf out) {
        writeVarInt( in, out );
        writeString( in, out );
        writePosition( in.readInt(), in.readInt(), in.readInt(), out );
        out.writeByte( in.readInt() );
    }
}
