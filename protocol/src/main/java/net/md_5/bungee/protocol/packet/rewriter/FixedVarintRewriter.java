package net.md_5.bungee.protocol.packet.rewriter;

import io.netty.buffer.ByteBuf;
import lombok.AllArgsConstructor;
import net.md_5.bungee.protocol.DefinedPacket;

@AllArgsConstructor
public class FixedVarintRewriter extends PacketRewriter
{
    public final int index;

    @Override
    public void rewrite(ByteBuf in, ByteBuf out) {
        out.writeBytes( in.readBytes( index ) );
        DefinedPacket.writeVarInt( in.readInt(), out );
        out.writeBytes( in.readBytes( in.readableBytes() ) );
    }
}
