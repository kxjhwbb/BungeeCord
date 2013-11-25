package net.md_5.bungee.netty.packetrewriter;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.netty.Var;

public class UpdateSignRewriter extends PacketRewriter
{

    @Override
    public void rewriteClientToServer(ByteBuf in, ByteBuf out)
    {
        out.writeInt( in.readInt() );
        out.writeShort( in.readShort() );
        out.writeInt( in.readInt() );
        for ( int i = 0; i < 4; i ++ )
        {
            Var.writeString( Var.readString( in, false ), out, true );
        }
    }

    @Override
    public void rewriteServerToClient(ByteBuf in, ByteBuf out)
    {
        out.writeInt( in.readInt() );
        out.writeShort( in.readShort() );
        out.writeInt( in.readInt() );
        for ( int i = 0; i < 4; i ++ )
        {
            Var.writeString( Var.readString( in, false ), out, true );
        }
    }

}
