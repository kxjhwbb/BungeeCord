package net.md_5.bungee.protocol.packet.rewriter.clientside;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.packet.rewriter.PacketRewriter;

public class ClientPlayerBlockPlacementRewriter extends PacketRewriter
{

    @Override
    public void rewrite(ByteBuf in, ByteBuf out)
    {
        int[] position = readPosition( in );
        out.writeInt( position[ 0 ] );
        out.writeByte( position[ 1 ] );
        out.writeInt( position[ 2 ] );
        out.writeBytes( in.readBytes( in.readableBytes() ) );
    }
}
