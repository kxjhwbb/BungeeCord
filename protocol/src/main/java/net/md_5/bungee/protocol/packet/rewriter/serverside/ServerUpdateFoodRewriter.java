package net.md_5.bungee.protocol.packet.rewriter.serverside;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.DefinedPacket;
import net.md_5.bungee.protocol.packet.rewriter.PacketRewriter;

public class ServerUpdateFoodRewriter extends PacketRewriter
{

    @Override
    public void rewrite(ByteBuf in, ByteBuf out)
    {
        out.writeBytes( in.readBytes( 4 ) );
        DefinedPacket.writeVarInt( in.readInt(), out );
        out.writeBytes( in.readBytes( in.readableBytes() ) );
    }
}
