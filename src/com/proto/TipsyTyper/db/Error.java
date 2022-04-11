package com.proto.TipsyTyper.db;

import com.proto.TipsyTyper.TipsyTyper;

import java.util.logging.Level;

public class Error {
    public static void execute(TipsyTyper plugin, Exception ex){
        plugin.getLogger().log(Level.SEVERE, "Couldn't execute MySQL statement: ", ex);
    }
    public static void close(TipsyTyper plugin, Exception ex){
        plugin.getLogger().log(Level.SEVERE, "Failed to close MySQL connection: ", ex);
    }
}