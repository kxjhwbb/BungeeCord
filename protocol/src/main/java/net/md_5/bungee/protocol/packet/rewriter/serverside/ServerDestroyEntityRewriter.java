package net.md_5.bungee.protocol.packet.rewriter.serverside;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.DefinedPacket;
import net.md_5.bungee.protocol.packet.rewriter.PacketRewriter;

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
