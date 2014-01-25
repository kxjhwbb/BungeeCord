package net.md_5.bungee.protocol.packet.rewriter.clientside;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.packet.rewriter.PacketRewriter;

public class ClientAnimationRewriter extends PacketRewriter
{

    @Override
    public void rewrite(ByteBuf in, ByteBuf out)
    {
        in.skipBytes( in.readableBytes() );
    }
}
