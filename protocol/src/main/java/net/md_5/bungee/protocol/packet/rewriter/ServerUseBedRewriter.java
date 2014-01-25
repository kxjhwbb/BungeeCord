package net.md_5.bungee.protocol.packet.rewriter;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.DefinedPacket;

public class ServerUseBedRewriter extends PacketRewriter
{
    @Override
    public void rewrite(ByteBuf in, ByteBuf out)
    {
        writeVarInt( in, out );
        rewritePosition( in, out );
    }
}
