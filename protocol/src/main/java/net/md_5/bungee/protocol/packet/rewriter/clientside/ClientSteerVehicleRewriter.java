package net.md_5.bungee.protocol.packet.rewriter.clientside;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.packet.rewriter.PacketRewriter;

public class ClientSteerVehicleRewriter extends PacketRewriter
{

    @Override
    public void rewrite(ByteBuf in, ByteBuf out)
    {
        out.writeBytes( in.readBytes( 4 ) );
        byte action = in.readByte();
        out.writeBoolean( action == 0x1 );
        out.writeBoolean( action == 0x2 );
    }
}
