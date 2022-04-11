package com.proto.TipsyTyper;

import com.proto.TipsyTyper.commands.gcom;
import com.proto.TipsyTyper.db.Database;
import com.proto.TipsyTyper.db.SQLite;
import com.proto.TipsyTyper.events.playerguess;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class TipsyTyper extends JavaPlugin {
    private Database db;
    @Override
    public void onEnable() {
        this.db = new SQLite(this);
        this.db.load();
        getServer().getPluginManager().registerEvents(new playerguess(), this);
        getCommand("starttt").setExecutor(new gcom());
        getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "[TiPsEyTyPeRisEnabled]:\n" + "   .\n" +
                "  .\n" +
                " . .\n" +
                "  ...\n" +
                "\\~~~~~/\n" +
                " \\   /\n" +
                "  \\ /\n" +
                "   V\n" +
                "   |\n" +
                "   |\n" +
                "  ---");
    }
    public Database getRDatabase() {
        return this.db;
    }
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[TipsyTyperIsDiSaBlEd]:\n" + "                    %%%%%%\n" +
                "                   %%%% = =\n" +
                "                   %%C    >\n" +
                "                    _)' _( .' ,\n" +
                "                 __/ |_/\\   \" *. o\n" +
                "                /` \\_\\ \\/     %`= '_  .\n" +
                "               /  )   \\/|      .^',*. ,\n" +
                "              /' /-   o/       - \" % '_\n" +
                "             /\\_/     <       = , ^ ~ .\n" +
                "             )_o|----'|          .`  '\n" +
                "         ___// (_  - (\\\n" +
                "        ///-(    \\'   \\\\");

    }
}
