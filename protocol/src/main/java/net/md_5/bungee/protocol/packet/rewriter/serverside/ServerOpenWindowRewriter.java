package net.md_5.bungee.protocol.packet.rewriter.serverside;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.DefinedPacket;
import net.md_5.bungee.protocol.packet.rewriter.PacketRewriter;

public class ServerOpenWindowRewriter extends PacketRewriter
{
    static String[] inventoryTypes = new String[ 0xFF ];
    static
    {
        inventoryTypes[ 0 ] = "minecraft:container";
        inventoryTypes[ 1 ] = "minecraft:workbench";
        inventoryTypes[ 2 ] = "minecraft:furnace";
        inventoryTypes[ 3 ] = "minecraft:dispenser";
        inventoryTypes[ 4 ] = "EnchantTable"; // Broken
        inventoryTypes[ 5 ] = "minecraft:brewing_stand";
        inventoryTypes[ 6 ] = "minecraft:villager";
        inventoryTypes[ 7 ] = "minecraft:beacon";
        inventoryTypes[ 8 ] = "minecraft:anvil";
        inventoryTypes[ 9 ] = "minecraft:hopper";
        inventoryTypes[ 11 ] = "EntityHorse";
    }

    @Override
    public void rewrite(ByteBuf in, ByteBuf out)
    {
        out.writeByte( in.readByte() );
        short inventoryType = in.readUnsignedByte();
        DefinedPacket.writeString( inventoryTypes[ inventoryType ], out );
        DefinedPacket.writeString( "{translate:\"" + DefinedPacket.readString( in ) + "\"}", out );
        //DefinedPacket.writeString( "{'translate':'tile.chest.name'}", out );
        //in.skipBytes(  DefinedPacket.readVarInt( in ) );
        out.writeByte( in.readByte() );
        in.skipBytes( 1 );
        out.writeBytes( in.readBytes( in.readableBytes() ) );
    }
}
