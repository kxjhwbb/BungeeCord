package net.md_5.bungee.protocol.packet.rewriter;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.DefinedPacket;

public class ServerOpenWindowRewriter extends PacketRewriter
{
    String[] inventoryTypes = {
        "Chest/Large chest",
            "Workbench",
            "Furnace",
            "Dispenser",
            "Enchantment table",
            "Brewing stand",
            "Npc trade",
            "Beacon",
            "Anvil",
            "Hopper"
    };

    @Override
    public void rewrite(ByteBuf in, ByteBuf out)
    {
        out.writeByte( in.readByte() );
        DefinedPacket.writeString( inventoryTypes[ in.readUnsignedByte() ], out );
        out.writeBytes( in.readBytes( in.readableBytes() ) );
    }
}
