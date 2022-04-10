package com.proto.TipsyTyper.events;


import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import java.util.regex.Pattern;

public class playerguess implements Listener {

    @EventHandler
    public static void onPlayerGuess(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        String sp = String.valueOf(p);
        String apn = String.valueOf("");
        Pattern en = Pattern.compile(apn);
        String pc = String.valueOf("cundoor");
        String m = event.getMessage();
        String pn = String.valueOf(p);
        Pattern pa = Pattern.compile(pc);

                if (en.matcher(sp).find()) {
                    if (pa.matcher(m).matches()) {
                        event.setMessage("I have committed a crime. I hope the unicorn will forgive the Crimes I have Committed!");
                        p.sendMessage(ChatColor.BLACK + "think again bud");}
                } else {
            }
        }
    }