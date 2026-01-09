package main.java.rpg.dao;

import main.java.rpg.core.CharacterClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CharacterDAO implements DAO<CharacterClass> {

    private Connection connection;

    public CharacterDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean save(CharacterClass character) {
        String sql = "INSERT INTO public.character(name, strength, agility, intelligence, health_points) VALUES (?, ?, ?, ?, ?);";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, character.getName());
            stmt.setInt(2, character.getStrength());
            stmt.setInt(3, character.getAgility());
            stmt.setInt(4, character.getIntelligence());
            stmt.setInt(5, character.getHealthPoints());
            int rowCreated = stmt.executeUpdate();
            return rowCreated == 1;
        }
        catch(SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean update(CharacterClass character) {
        String sql = "UPDATE public.character SET strength = ?, agility = ?, intelligence = ?, health_points = ? WHERE name = ?;";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, character.getStrength());
            stmt.setInt(2, character.getAgility());
            stmt.setInt(3, character.getIntelligence());
            stmt.setInt(4, character.getHealthPoints());
            stmt.setString(4, character.getName());
            int rowUpdated = stmt.executeUpdate();
            return rowUpdated == 1;
        }
        catch(SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean delete(CharacterClass character) {
        String sql = "DELETE FROM public.character WHERE name = ?;";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, character.getName());
            int rowDeleted = stmt.executeUpdate();
            return rowDeleted > 1;
        }
        catch(SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public CharacterClass findByName(String name) {
        String sql = "SELECT * FROM public.character WHERE name = ?;";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return new CharacterClass.CharacterBuilder(rs.getString("name"))
                        .setStrength(rs.getInt("strength"))
                        .setAgility(rs.getInt("agility"))
                        .setIntelligence(rs.getInt("intelligence"))
                        .setHealth(rs.getInt("health_points"))
                        .build();
            }
        }
        catch(SQLException e) {

        }
        return null;
    }

    @Override
    public List<CharacterClass> findAll() {
        List<CharacterClass> characters = new ArrayList<>();
        String sql = "SELECT * FROM public.character;";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                characters.add(new CharacterClass.CharacterBuilder(rs.getString("name"))
                        .setStrength(rs.getInt("strength"))
                        .setAgility(rs.getInt("agility"))
                        .setIntelligence(rs.getInt("intelligence"))
                        .setHealth(rs.getInt("health_points"))
                        .build());
            }
            return characters;
        }
        catch(SQLException e) {

        }
        return null;
    }
}
