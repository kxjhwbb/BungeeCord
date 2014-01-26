package net.md_5.bungee.protocol.packet.rewriter.clientside;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.packet.rewriter.PacketRewriter;

import java.nio.charset.Charset;

public class ClientAnimationRewriter extends PacketRewriter
{

    @Override
    public void rewrite(ByteBuf in, ByteBuf out)
    {
        out.writeInt( 12342 ); // EntityMap should rewrite this anyway
        out.writeByte( 5 ); // Lets just eat for now, ok?
    }
}
