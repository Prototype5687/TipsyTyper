package com.proto.TipsyTyper.commands;

import com.proto.TipsyTyper.db.Database;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.Connection;

import static org.bukkit.Bukkit.getServer;

public class gcom implements CommandExecutor {
    Database db = new Database() {
        @Override
        public Connection getSQLConnection() {
            return null;
        }

        @Override
        public void load() {

        }
    };
    @Override
    public boolean onCommand(CommandSender Sender, Command cmd, String label, String[] args){
        if (!(Sender instanceof Player)) {
            return true;
        }
        Player player = (Player) Sender;
        Long invitetime = System.currentTimeMillis();
        if (cmd.getName().equalsIgnoreCase("starttt")) {

            getServer().getConsoleSender().sendMessage("hi");
            db.setPlayer(0, player, invitetime);
            Long hi = db.getTime(player);
            String shi = String.valueOf(hi);
            getServer().getConsoleSender().sendMessage(shi);
        }
        return true;
    }
}
