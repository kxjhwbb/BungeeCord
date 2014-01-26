package net.md_5.bungee.protocol;

import net.md_5.bungee.protocol.packet.rewriter.*;
import net.md_5.bungee.protocol.packet.rewriter.clientside.*;
import net.md_5.bungee.protocol.packet.rewriter.serverside.*;

public class RewriterMappings {
    public static final PacketRewriter[] serverToClient = new PacketRewriter[ 0xFF ];
    public static final PacketRewriter[] clientToServer = new PacketRewriter[ 0xFF ];

    static {
        serverToClient[ 0x02 ] = new ServerChatRewriter();
        serverToClient[ 0x04 ] = new ServerEntityIdRewriter();
        serverToClient[ 0x05 ] = new ServerSpawnPositionRewriter();
        serverToClient[ 0x06 ] = new ServerUpdateFoodRewriter();
        serverToClient[ 0x08 ] = new ServerPositionRewriter();
        serverToClient[ 0x0A ] = new ServerUseBedRewriter();
        serverToClient[ 0x0C ] = new ServerSpawnPlayerRewriter();
        serverToClient[ 0x0D ] = new ServerCollectItemRewriter();
        serverToClient[ 0x10 ] = new ServerSpawnPaintingRewriter();
        serverToClient[ 0x12 ] = new ServerEntityIdRewriter();
        serverToClient[ 0x13 ] = new ServerDestroyEntityRewriter();
        serverToClient[ 0x14 ] = new ServerEntityIdRewriter();
        serverToClient[ 0x15 ] = new ServerEntityIdRewriter(); // Not on wiki.vg
        serverToClient[ 0x16 ] = new ServerEntityIdRewriter(); // Not on wiki.vg
        serverToClient[ 0x17 ] = new ServerEntityIdRewriter(); // Not on wiki.vg
        serverToClient[ 0x18 ] = new ServerEntityIdRewriter();
        serverToClient[ 0x19 ] = new ServerEntityIdRewriter();
        // TEST
        serverToClient[ 0x1A ] = new ServerEntityIdRewriter();
        serverToClient[ 0x1B ] = new ServerEntityIdRewriter();
        // - Test
        serverToClient[ 0x1C ] = new ServerEntityIdRewriter();
        serverToClient[ 0x1D ] = new ServerEntityEffectRewriter();
        serverToClient[ 0x1E ] = new ServerEntityIdRewriter();
        serverToClient[ 0x1F ] = new ServerSetExperienceRewriter();
        serverToClient[ 0x20 ] = new ServerEntityPropertiesRewriter();
        serverToClient[ 0x23 ] = new ServerBlockChangeRewriter();
        serverToClient[ 0x24 ] = new ServerBlockActionRewriter();
        serverToClient[ 0x25 ] = new ServerBlockBreakAnimationRewriter();
        serverToClient[ 0x28 ] = new ServerEffectRewriter();
        serverToClient[ 0x2D ] = new ServerOpenWindowRewriter();
        serverToClient[ 0x33 ] = new PositionShortRewriter();
        serverToClient[ 0x35 ] = new PositionShortRewriter();
        serverToClient[ 0x36 ] = new PositionIntRewriter();
        serverToClient[ 0x38 ] = new ServerPlayerListItemRewriter();
        serverToClient[ 0x3C ] = new ServerUpdateScoreRewriter();
        serverToClient[ 0x3E ] = new ServerTeamRewriter();


        // TODO: What to do about 0x41 and 0x42?
        clientToServer[ 0x00 ] = new ClientEntityIdRewriter();
        clientToServer[ 0x02 ] = new ClientEntityIdRewriter();
        clientToServer[ 0x07 ] = new ClientDiggingRewriter();
        clientToServer[ 0x08 ] = new ClientPlayerBlockPlacementRewriter();
        clientToServer[ 0x0A ] = new ClientAnimationRewriter();
        clientToServer[ 0x0B ] = new ClientEntityActionRewriter();
        clientToServer[ 0x0C ] = new ClientSteerVehicleRewriter();
        clientToServer[ 0x12 ] = new ClientUpdateSignRewriter();
        clientToServer[ 0x15 ] = new ClientClientSettingRewriter();
    }
}
