package net.md_5.bungee.protocol.packet.rewriter;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.DefinedPacket;

public abstract class PacketRewriter
{
    public abstract void rewrite(ByteBuf in, ByteBuf out);

    // Disclaimer - I have no idea what I'm doing here.
    public void writePosition(int x, int y, int z, ByteBuf buf)
    {
        long position = 0;
        position |= x & 0xFFFFFFF000000000L;
        position |= y & 0x0000000FF0000000L;
        position |= z & 0x000000000FFFFFFFL;
        buf.writeLong( position );
    }

    public void rewritePosition(ByteBuf in, ByteBuf out)
    {
        writePosition( in.readInt(), in.readInt(), in.readInt(), out );
    }

    public int writeVarInt(ByteBuf in, ByteBuf out)
    {
        int varintsize = 0;
        byte current;
        /*
         This is for when we don't care about the int, however it will return the number of bytes, just want to write
          it. Since the first bit of the byte is what defines if the value has ended a signed byte will be negative.
          */
        while ( ( current = in.readByte() ) > 0 )
        {
            out.writeByte( current );
            varintsize++;
        }
        return varintsize;
    }

    public void writeString(ByteBuf in, ByteBuf out)
    {
        int size = DefinedPacket.readVarInt( in );
        DefinedPacket.writeVarInt( size, out );
        out.writeBytes( in.readBytes( size ) );
    }

    public int[] readPosition(ByteBuf in) {
        int[] result = new int[ 3 ];
        long position = in.readLong();
        result[ 0 ] = (int)(position & 0xFFFFFFF000000000L);
        result[ 1 ] = (int)(position & 0x0000000FF0000000L);
        result[ 2 ] = (int)(position & 0x000000000FFFFFFFL);
        return result;
    }

}
