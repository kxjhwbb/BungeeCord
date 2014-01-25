package net.md_5.bungee.protocol.packet.rewriter;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.DefinedPacket;

public class ServerSpawnPlayerRewriter extends PacketRewriter
{

    @Override
    public void rewrite(ByteBuf in, ByteBuf out)
    {
        writeVarInt( in, out );
        writeString( in, out );
        writeString( in, out );
        DefinedPacket.writeVarInt( 0, out );
        out.writeBytes( in.readBytes( in.readableBytes() ) );
    }
}
