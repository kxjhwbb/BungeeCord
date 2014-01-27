package net.md_5.bungee.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import net.md_5.bungee.protocol.packet.rewriter.PacketRewriter;

public class RewriterEncoder extends MessageToByteEncoder<ByteBuf>
{
    @Override
    protected void encode(ChannelHandlerContext ctx, ByteBuf in, ByteBuf out) throws Exception
    {
        int packetId = DefinedPacket.readVarInt( in );
        DefinedPacket.writeVarInt( packetId, out );
        PacketRewriter rewriter = RewriterMappings.serverToClient[ packetId ];
        System.out.println( Integer.toHexString( packetId ) );
        if ( rewriter == null ) {
            out.writeBytes( in.readBytes( in.readableBytes() ) );
        } else {
            rewriter.rewrite( in, out );
        }
    }
}
