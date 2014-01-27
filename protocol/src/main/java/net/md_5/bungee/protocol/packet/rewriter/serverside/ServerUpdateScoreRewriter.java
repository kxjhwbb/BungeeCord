package net.md_5.bungee.protocol.packet.rewriter.serverside;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.DefinedPacket;
import net.md_5.bungee.protocol.packet.rewriter.PacketRewriter;

public class ServerUpdateScoreRewriter extends PacketRewriter
{

    @Override
    public void rewrite(ByteBuf in, ByteBuf out)
    {
        writeString( in, out );
        int updateRemove = in.readByte();
        out.writeByte( updateRemove );
        writeString( in, out );
        if ( updateRemove != 1 )
        {
            DefinedPacket.writeVarInt( in.readInt(), out );
            out.writeBytes( in.readBytes( in.readableBytes() ) );
        }
    }
}
