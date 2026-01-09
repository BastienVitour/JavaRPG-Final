package main.java.rpg.controllers;

import main.java.rpg.core.FightLog;
import main.java.rpg.dao.FightLogDAO;
import main.java.rpg.settings.DatabaseConnection;

import java.sql.Connection;
import java.util.List;

public class FightLogController implements Controller<FightLog> {

    private FightLogDAO fightLogDAO;

    public FightLogController() {
        Connection connection = DatabaseConnection.getConnection();
        this.fightLogDAO = new FightLogDAO(connection);
    }

    @Override
    public List<FightLog> findAll() {
        return this.fightLogDAO.findAll();
    }

    @Override
    public boolean save(FightLog fightLog) {
        return this.fightLogDAO.save(fightLog);
    }
}
