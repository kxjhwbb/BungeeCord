package net.md_5.bungee.protocol.packet.rewriter;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.DefinedPacket;

public class ServerEntityEffectRewriter extends PacketRewriter
{

    @Override
    public void rewrite(ByteBuf in, ByteBuf out)
    {
        DefinedPacket.writeVarInt( in.readInt(), out );
        out.writeBytes( in.readBytes( 2 ) );
        DefinedPacket.writeVarInt( in.readShort(), out );
    }
}
