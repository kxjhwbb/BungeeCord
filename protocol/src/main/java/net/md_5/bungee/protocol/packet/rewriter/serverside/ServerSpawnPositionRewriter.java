package net.md_5.bungee.protocol.packet.rewriter.serverside;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.packet.rewriter.PacketRewriter;

public class ServerSpawnPositionRewriter extends PacketRewriter
{

    @Override
    public void rewrite(ByteBuf in, ByteBuf out)
    {
        writePosition( in.readInt(), in.readInt(), in.readInt(), out );
    }
}
