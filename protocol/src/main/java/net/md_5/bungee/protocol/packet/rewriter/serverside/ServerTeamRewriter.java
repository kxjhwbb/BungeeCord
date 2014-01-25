package net.md_5.bungee.protocol.packet.rewriter.serverside;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.DefinedPacket;
import net.md_5.bungee.protocol.packet.rewriter.PacketRewriter;

public class ServerTeamRewriter extends PacketRewriter
{

    @Override
    public void rewrite(ByteBuf in, ByteBuf out)
    {
        writeString( in, out );
        out.writeByte( in.readByte() );
        writeString( in, out );
        writeString( in, out );
        writeString( in, out );
        out.writeByte( in.readByte() );
        DefinedPacket.writeVarInt( in.readShort(), out );
        out.writeBytes( in.readBytes( in.readableBytes() ) );
    }
}
