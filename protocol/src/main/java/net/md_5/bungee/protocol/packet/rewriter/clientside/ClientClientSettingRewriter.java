package net.md_5.bungee.protocol.packet.rewriter.clientside;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.DefinedPacket;
import net.md_5.bungee.protocol.packet.rewriter.PacketRewriter;

public class ClientClientSettingRewriter extends PacketRewriter
{

    @Override
    public void rewrite(ByteBuf in, ByteBuf out)
    {
        DefinedPacket.writeString( DefinedPacket.readString( in ), out );
        out.writeBytes( in.readBytes( 3 ) );
        out.writeByte( 1 );
        out.writeBoolean( true );
    }
}
