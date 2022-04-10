package com.proto.TipsyTyper.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamecommands implements CommandExecutor {
    long invitetime = 0;
    long expinvite = 0;
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "FUCK OFF");
            return true;}
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("starttt")) {
            boolean game = true;
            invitetime = System.currentTimeMillis();
            expinvite = invitetime + 300000;
            player.sendMessage("initiated");


        }
        if (cmd.getName().equalsIgnoreCase("yes")) {
            String exinv = String.valueOf(invitetime);
            player.sendMessage(exinv);


        }
        return true;
    }

}
