package net.md_5.bungee.protocol.packet.rewriter;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.DefinedPacket;

public class ServerDestroyEntityRewriter extends PacketRewriter
{

    @Override
    public void rewrite(ByteBuf in, ByteBuf out)
    {
        int size = in.readByte();
        DefinedPacket.writeVarInt( size, out );

        for ( int i = 0; i < size; i++ ) {
            DefinedPacket.writeVarInt( in.readInt(), out );
        }
    }
}
