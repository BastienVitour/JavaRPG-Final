package main.java.rpg.dao;

import main.java.rpg.core.Army;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArmyDAO implements DAO<Army> {

    private Connection connection;

    public ArmyDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean save(Army army) {
        String sql = "INSERT INTO public.army(name) VALUES (?);";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, army.getName());
            int rowCreated = stmt.executeUpdate();
            return rowCreated == 1;
        }
        catch(SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean update(Army army) {
        return false;
    }

    @Override
    public boolean delete(Army army) {
        return false;
    }

    @Override
    public Army findByName(String name) {
        String sql = "SELECT * FROM public.army WHERE name = ?;";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return new Army(rs.getString("name"));
            }
        }
        catch(SQLException e) {
            return null;
        }
        return null;
    }

    @Override
    public List<Army> findAll() {
        List<Army> armies = new ArrayList<>();
        String sql = "SELECT * FROM public.army;";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                armies.add(new Army(rs.getString("name")));
            }
            return armies;
        }
        catch(SQLException e) {

        }
        return null;
    }
}
