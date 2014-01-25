package net.md_5.bungee.protocol.packet.rewriter.serverside;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.DefinedPacket;
import net.md_5.bungee.protocol.packet.rewriter.PacketRewriter;

public class ServerEntityPropertiesRewriter extends PacketRewriter
{

    @Override
    public void rewrite(ByteBuf in, ByteBuf out)
    {
        DefinedPacket.writeVarInt( in.readInt(), out );
        int count = in.readInt();
        out.writeInt( count );

        for ( int i = 0; i < count; i++ )
        {
            writeString( in, out );
            out.writeBytes( in.readBytes( 8 ) );
            short arraySize = in.readShort();
            DefinedPacket.writeVarInt( arraySize, out );

            for ( int j = 0; j < arraySize; j++ )
            {
                out.writeBytes( in.readBytes( 25 ) );
            }
        }
    }
}
