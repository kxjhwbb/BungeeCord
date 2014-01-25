package net.md_5.bungee.protocol.packet.rewriter.serverside;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.packet.rewriter.PacketRewriter;

public class ServerEffectRewriter extends PacketRewriter
{

    @Override
    public void rewrite(ByteBuf in, ByteBuf out)
    {
        out.writeBytes( in.readBytes( 4 ) );
        writePosition( in.readInt(), in.readByte(), in.readInt(), out );
        out.writeBytes( in.readBytes( in.readableBytes() ) );
    }
}
