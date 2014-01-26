package net.md_5.bungee.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import net.md_5.bungee.protocol.packet.rewriter.PacketRewriter;

import java.util.List;

public class RewriterDecoder extends ByteToMessageDecoder
{
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception
    {
        int packetId = DefinedPacket.readVarInt( in );
        PacketRewriter rewriter = RewriterMappings.clientToServer[ packetId ];
        ByteBuf packet = Unpooled.buffer();
        if ( rewriter == null )
        {
            if ( packetId != 0x7F )
            {
            DefinedPacket.writeVarInt( packetId, packet );
            packet.writeBytes( in.readBytes( in.readableBytes() ) );
            out.add( packet );
            }
        }
        else {
            DefinedPacket.writeVarInt( packetId, packet );
            rewriter.rewrite( in, packet );
            out.add( packet );
        }
    }
}
