package net.md_5.bungee.command;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Command;

public class CommandBungee extends Command
{

    public CommandBungee()
    {
        super( "bungee" );
    }

    @Override
    public void execute(CommandSender sender, String[] args)
    {
        sender.sendMessage( ChatColor.GREEN + "专业优化强化BungeeCord，多版本支持，【QQ:284107809】  BungeeCord版权所有：原作者md_5， 本次构建ID："+ ProxyServer.getInstance().getVersion() );
        //sender.sendMessage( ChatColor.BLUE + "This server is running BungeeCord version " + ProxyServer.getInstance().getVersion() + " by md_5" );
    }
}
