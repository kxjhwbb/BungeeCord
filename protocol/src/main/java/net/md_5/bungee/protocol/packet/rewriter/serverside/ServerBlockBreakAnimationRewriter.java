package net.md_5.bungee.protocol.packet.rewriter.serverside;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.packet.rewriter.PacketRewriter;

public class ServerBlockBreakAnimationRewriter extends PacketRewriter
{

    @Override
    public void rewrite(ByteBuf in, ByteBuf out)
    {
        writeVarInt( in, out );
        rewritePosition( in, out );
        out.writeByte( in.readByte() );
    }
}