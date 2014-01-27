package net.md_5.bungee.protocol.packet.rewriter.clientside;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.DefinedPacket;
import net.md_5.bungee.protocol.packet.rewriter.PacketRewriter;

public class ClientEntityActionRewriter extends PacketRewriter
{

    @Override
    public void rewrite(ByteBuf in, ByteBuf out)
    {
        out.writeInt( DefinedPacket.readVarInt( in ) );
        byte actionId = (byte)(in.readByte() + 1);
        out.writeByte( actionId );
        out.writeInt( DefinedPacket.readVarInt( in ) );
    }
}
