package main.java.rpg.dao;

import main.java.rpg.core.Army;
import main.java.rpg.core.CharacterClass;
import main.java.rpg.core.Guild;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuildDAO implements DAO<Guild> {

    private Connection connection;

    public GuildDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean save(Guild guild) {
        String sql = "INSERT INTO public.guild(name) VALUES (?);";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, guild.getName());
            int rowCreated = stmt.executeUpdate();
            return rowCreated == 1;
        }
        catch(SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean update(Guild guild) {
        return false;
    }

    @Override
    public boolean delete(Guild guild) {
        return false;
    }

    @Override
    public Guild findByName(String name) {
        String sql = "SELECT * FROM public.guild WHERE name = ?;";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return new Guild(rs.getString("name"));
            }
        }
        catch(SQLException e) {
            return null;
        }
        return null;
    }

    @Override
    public List<Guild> findAll() {
        List<Guild> guilds = new ArrayList<>();
        String sql = "SELECT * FROM public.guild;";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                guilds.add(new Guild(rs.getString("name")));
            }
            return guilds;
        }
        catch(SQLException e) {

        }
        return null;
    }
}
