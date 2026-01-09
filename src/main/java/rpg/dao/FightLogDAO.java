package main.java.rpg.dao;

import main.java.rpg.core.CharacterClass;
import main.java.rpg.core.FightLog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FightLogDAO implements DAO<FightLog> {

    private Connection connection;

    public FightLogDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean save(FightLog fightLog) {
        String sql = "INSERT INTO public.fight_log(character1, character2, datetime, winner, action_log) VALUES (?, ?, ?, ?, ?);";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, fightLog.getCharacter1());
            stmt.setString(2, fightLog.getCharacter2());
            stmt.setTimestamp(3, fightLog.getDateTime());
            stmt.setString(4, fightLog.getWinner());
            stmt.setString(5, fightLog.getActionLog());
            int rowCreated = stmt.executeUpdate();
            return rowCreated == 1;
        }
        catch(SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean update(FightLog item) {
        return false;
    }

    @Override
    public boolean delete(FightLog item) {
        return false;
    }

    @Override
    public FightLog findByName(String name) {
        return null;
    }

    @Override
    public List<FightLog> findAll() {
        List<FightLog> fightLogs = new ArrayList<>();
        String sql = "SELECT * FROM public.fight_log;";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                fightLogs.add(new FightLog.FightLogBuilder()
                        .setCharacter1(rs.getString("character1"))
                        .setCharacter2(rs.getString("character2"))
                        .setTimestamp(rs.getTimestamp("datetime"))
                        .setWinner(rs.getString("winner"))
                        .setActionLog(rs.getString("action_log"))
                        .build());
            }
            return fightLogs;
        }
        catch(SQLException e) {

        }
        return null;
    }
}
