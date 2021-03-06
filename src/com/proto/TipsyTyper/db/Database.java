package com.proto.TipsyTyper.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import org.bukkit.entity.Player;

import com.proto.TipsyTyper.TipsyTyper;


public abstract class Database {
    TipsyTyper plugin;
    Connection connection;

    public String table = "Players";
    public int tokens = 0;
    public Database(TipsyTyper instance){
        plugin = instance;
    }

    public Database() {

    }

    public abstract Connection getSQLConnection();

    public abstract void load();

    public void initialize(){
        connection = getSQLConnection();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + table + " WHERE num = ?");
            ResultSet rs = ps.executeQuery();
            close(ps,rs);

        } catch (SQLException ex) {
            plugin.getLogger().log(Level.SEVERE, "Unable to retrieve connection", ex);
        }
    }


    public String getPLayer(Integer inte) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getSQLConnection();
            ps = conn.prepareStatement("SELECT player FROM " + table + " WHERE num = '"+inte+"';");

            rs = ps.executeQuery();

                    return rs.getString("player");

        } catch (SQLException ex) {
            plugin.getLogger().log(Level.SEVERE, Errors.sqlConnectionExecute(), ex);
        } finally {
            try {
                if (ps != null)
                    ps.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                plugin.getLogger().log(Level.SEVERE, Errors.sqlConnectionClose(), ex);
            }
        }
        return ";)";
    }
    public Long getTime(Player player) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Long ret = Long.getLong("0");
        try {
            conn = getSQLConnection();
            ps = conn.prepareStatement("SELECT time FROM " + table + " WHERE player = '"+player+"';");

            rs = ps.executeQuery();

            return rs.getLong("time");

        } catch (SQLException ex) {
            plugin.getLogger().log(Level.SEVERE, Errors.sqlConnectionExecute(), ex);
        } finally {
            try {
                if (ps != null)
                    ps.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                plugin.getLogger().log(Level.SEVERE, Errors.sqlConnectionClose(), ex);
            }
        }
        return ret;
    }

    public void setPlayer( Integer num, Player player, Long time) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getSQLConnection();
            ps = conn.prepareStatement("REPLACE INTO " + table + " (num,player,time) VALUES(?,?,?)");
            ps.setString(2, player.getName().toLowerCase());                                           
            ps.setInt(1, num);
            ps.setLong(3, time);
            ps.executeUpdate();
            return;
        } catch (SQLException ex) {
            plugin.getLogger().log(Level.SEVERE, Errors.sqlConnectionExecute(), ex);
        } finally {
            try {
                if (ps != null)
                    ps.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                plugin.getLogger().log(Level.SEVERE, Errors.sqlConnectionClose(), ex);
            }
        }
        return;
    }


    public void close(PreparedStatement ps,ResultSet rs){
        try {
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();
        } catch (SQLException ex) {
            Error.close(plugin, ex);
        }
    }
}
