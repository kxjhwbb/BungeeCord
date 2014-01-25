package net.md_5.bungee.protocol.packet.rewriter.clientside;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.packet.rewriter.PacketRewriter;

public class ClientDiggingRewriter extends PacketRewriter {

    @Override
    public void rewrite(ByteBuf in, ByteBuf out)
    {
        out.writeByte( in.readByte() );
        int[] position = readPosition( in );
        out.writeInt( position[ 0 ] );
        out.writeByte( position[ 1 ] );
        out.writeInt( position[ 2 ] );
        out.writeByte( in.readByte() );
    }
}
