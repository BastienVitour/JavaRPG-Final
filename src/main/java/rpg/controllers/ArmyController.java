package main.java.rpg.controllers;

import main.java.rpg.core.Army;
import main.java.rpg.dao.ArmyDAO;
import main.java.rpg.settings.DatabaseConnection;
import main.java.rpg.validators.ArmyValidator;

import java.sql.Connection;
import java.util.List;

public class ArmyController implements Controller<Army> {

    private ArmyDAO armyDAO;

    public ArmyController() {
        Connection connection = DatabaseConnection.getConnection();
        this.armyDAO = new ArmyDAO(connection);
    }

    @Override
    public List<Army> findAll() {
        return this.armyDAO.findAll();
    }

    @Override
    public boolean save(Army army) {

        boolean creationValid = false;

        ArmyValidator armyValidator = new ArmyValidator(this.armyDAO);
        if(armyValidator.validateArmy(army)) {
            return this.armyDAO.save(army);
        }

        return creationValid;
    }
}
