package com.proto.TipsyTyper.db;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import com.proto.TipsyTyper.db.Database;
import com.proto.TipsyTyper.TipsyTyper;


public class SQLite extends Database {
    String dbname;

    public SQLite(TipsyTyper instance) {
        super(instance);
        dbname = plugin.getConfig().getString("SQLite.Filename", "players");
    }
    //SQLite.Filename
    public String SQLiteCreateTokensTable = "CREATE TABLE IF NOT EXISTS Players (" + "`num` int(11) NOT NULL," + "`player` varchar(32) NOT NULL," + "'time' int(11) NOT NULL," + "PRIMARY KEY (`num`)" + ");";

    public Connection getSQLConnection() {
        File dataFolder = new File(plugin.getDataFolder(), dbname + ".db");
        if (!dataFolder.exists()) {
            try {
                dataFolder.createNewFile();
            } catch (IOException e) {
                plugin.getLogger().log(Level.SEVERE, "File write error: " + dbname + ".db");
            }
        }
        try {
            if (connection != null && !connection.isClosed()) {
                return connection;
            }
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + dataFolder);
            return connection;
        } catch (SQLException ex) {
            plugin.getLogger().log(Level.SEVERE, "SQLite exception on initialize", ex);
        } catch (ClassNotFoundException ex) {
            plugin.getLogger().log(Level.SEVERE, "You need the SQLite JBDC library. Google it. Put it in /lib folder.");
        }
        return null;
    }

    public void load() {
        connection = getSQLConnection();
        try {
            Statement s = connection.createStatement();
            s.executeUpdate(SQLiteCreateTokensTable);
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        initialize();
    }
}