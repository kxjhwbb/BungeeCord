package net.md_5.bungee.protocol.packet.rewriter;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.DefinedPacket;

import java.util.Arrays;

public abstract class PacketRewriter
{
    public abstract void rewrite(ByteBuf in, ByteBuf out);

    public void writePosition(int x, int y, int z, ByteBuf buf)
    {
        long position =
                ((long)x & 0x3FFFFFF) << 38
                | ((long)y & 0xFFF) << 12
                | ((long)z & 0x3FFFFFF);

        buf.writeLong( position );
    }

    public int[] readPosition(ByteBuf in) {
        int[] result = new int[ 3 ];
        long position = in.readLong();

        result[ 0 ] = (int)(position >> 38);
        result[ 1 ] = (int)(position << 26 >> 52);
        result[ 2 ] = (int)(position << 38 >> 38);

        return result;
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

}
