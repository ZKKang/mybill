package gui.dao;

import gui.entity.Config;
import gui.util.DBUtil;
import sun.misc.Cache;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConfigDAO {

    public int getTotal() {
        int total = 0;
        try(Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "SELECT COUNT(*) FROM CONFIG";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    public void add(Config config) {
        String sql = "insert into config values(null,?,?)";
        try(Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1,config.getCode());
            ps.setString(2,config.getValue());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
               int id = rs.getInt(1);
               config.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Config config) {
        String sql = "update config set code = ?, value = ? where id = ?";
        try(Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1,config.getCode());
            ps.setString(2,config.getValue());
            ps.setInt(3,config.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "delete from config where id = " + id;

            s.execute(sql);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public Config get(int id) {
        Config config = null;
        try(Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from config where id = "+id;
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                config = new Config();
                config.setId(rs.getInt("ID"));
                config.setCode(rs.getString("CODE"));
                config.setValue(rs.getString("VALUE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return config;
    }

    public List<Config> list(int start, int count) {
        List<Config> configs = new ArrayList<Config>();

        String sql = "select * from config order by id desc limit ?,? ";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Config config = new Config();
                int id = rs.getInt(1);
                config.setId(id);
                config.setCode(rs.getString("CODE"));
                config.setValue(rs.getString("VALUE"));
                configs.add(config);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return configs;
    }

    public Config getByCode(String code) {
        Config config = null;
        String sql = "select * from config where CODE = ?" ;
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ) {

            ps.setString(1, code);
            ResultSet rs =ps.executeQuery();

            if (rs.next()) {
                config = new Config();
                config.setId(rs.getInt("ID"));
                config.setCode(code);
                config.setValue(rs.getString("VALUE"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return config;
    }
    public List<Config> list() {
        return list(0, Short.MAX_VALUE);
    }
}
